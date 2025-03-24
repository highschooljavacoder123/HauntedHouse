public class User {
    private String name;
    private double health;
    private int sanity;
    private int speed;
    private String[] inventory;
    private int inventorySize; 

    public User(String name, double health, int sanity, int speed, int maxInventorySize) {
        this.name = name;
        this.health = health;
        this.sanity = sanity;
        this.speed = speed;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
        StringBuilder inv = new StringBuilder("[");
        for (int i = 0; i < inventorySize; i++) {
            inv.append(inventory[i]);
            if (i < inventorySize - 1) inv.append(", ");
        }
        inv.append("]");

        return "User{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", sanity=" + sanity +
                ", speed=" + speed +
                ", inventory=" + inv +
                '}';
    }
}