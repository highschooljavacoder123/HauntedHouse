public class User {
    private String name;
    private double health;
    private int sanity;
    private int attack;
    private Inventory[] inventory;
    private int inventorySize; 
    

    public User(String name, double health, int sanity, int attack, int maxInventorySize) {
        this.name = name;
        this.health = health;
        this.sanity = sanity;
        this.attack = attack;
        this.inventory = new Inventory[maxInventorySize]; 
        this.inventorySize = 0;
       
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getSanity() {
        return sanity;
    }

    public void setSanity(int sanity) {
        this.sanity = sanity;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Inventory[] getInventory() {
        return inventory;
    }

    public int getInventorySize(){
        return inventorySize;
    }

    public void printInventory() {
        String output = "[";
        for (int i = 0; i < inventorySize; i++){
            output += inventory[i].toString()+ "\n";

        }
        System.out.println(output + "]");

    }
    public void addItemToInventory(Inventory item) {
        if (inventorySize < inventory.length) {
            inventory[inventorySize++] = item;
        } else {
            System.out.println("Inventory is full! Cannot add " + item);
        }
    }

    public void removeItemFromInventory(Inventory item) {
        for (int i = 0; i < inventorySize; i++) {
            if (inventory[i].equals(item)) {
               
                for (int j = i; j < inventorySize - 1; j++) {
                    inventory[j] = inventory[j + 1];
                }
                inventory[inventorySize - 1] = null;
                inventorySize--;
                return;
            }
        }
        System.out.println("Item not found in inventory!");
    }


    public String getRole(){
        return "";
    }

    public int[] move(String direction, int currentRow, int currentCol, Room[][] map) {
        int newRow = currentRow;
        int newCol = currentCol;
    
        direction = direction.toLowerCase();
    
        if (direction.equals("up")) {
            newRow--;
        } else if (direction.equals("down")) {
            newRow++;
        } else if (direction.equals("left")) {
            newCol--;
        } else if (direction.equals("right")) {
            newCol++;
        } else {
            System.out.println("Invalid direction.");
            return new int[]{currentRow, currentCol};
        }
    
        // Bounds check and null room check
        if (newRow < 0 || newRow >= map.length || newCol < 0 || newCol >= map[0].length || map[newRow][newCol] == null) {
            System.out.println("You can't move that way.");
            return new int[]{currentRow, currentCol};
        }
    
        Room nextRoom = map[newRow][newCol];
    
        // Locked room check
        if (nextRoom.isLocked()) {
            String requiredKey = nextRoom.getRequiredKeyName();
            boolean hasKey = false;
    
            for (Inventory item : this.getInventory()) {
                if (item instanceof Key) {
                    Key key = (Key) item;
                    if (!key.isUsed() && key.getRoomName().equalsIgnoreCase(requiredKey)) {
                        hasKey = true;
                        key.useKey();
                        nextRoom.setLocked(false, ""); // Unlock it
                        System.out.println("You used the " + key.getName() + " to unlock the " + requiredKey + ".");
                        break;
                    }
                }
            }
    
            if (!hasKey) {
                System.out.println("The " + nextRoom.getName() + " is locked! You need the " + requiredKey + " key.");
                return new int[]{currentRow, currentCol};
            }
        }
    
        System.out.println("You moved " + direction + " to " + nextRoom.getName());
        return new int[]{newRow, newCol};

    }
    @Override
    public String toString() {
        String inventoryDisplay = "[";

        if (inventorySize !=0) {
            for (int i = 0; i<inventorySize-1; i++){
                inventoryDisplay+= inventory[i] +", ";
            }
            inventoryDisplay+= inventory[inventorySize-1] +"]";
        
        }

        else {
            inventoryDisplay += "]";
        }
        

        return "name='" + name + '\'' + "\nhealth=" + health + "\nsanity=" + sanity +"\nattack=" + attack + "\ninventory=" + inventoryDisplay;
    }
}