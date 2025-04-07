public class User {
    private String name;
    private double health;
    private int sanity;
    private int attack;
    private String[] inventory;
    private int inventorySize; 

    public User(String name, double health, int sanity, int attack, int maxInventorySize) {
        this.name = name;
        this.health = health;
        this.sanity = sanity;
        this.attack = attack;
        this.inventory = new String[maxInventorySize]; 
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

    public String[] getInventory() {
        return inventory;
    }

    public void addItemToInventory(String item) {
        if (inventorySize < inventory.length) {
            inventory[inventorySize++] = item;
        } else {
            System.out.println("Inventory is full! Cannot add " + item);
        }
    }

    public void removeItemFromInventory(String item) {
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

    @Override
    public String toString() {
        String inventoryDisplay = "[";
        for (int i = 0; i<inventorySize-1; i++){
            inventoryDisplay+= inventory[i] +", ";
        }
        inventoryDisplay+= inventory[inventorySize-1] +"]";

        return "User{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", sanity=" + sanity +
                ", attack=" + attack +
                ", inventory=" + inventoryDisplay +
                '}';
    }
}