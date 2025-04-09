public class Skeptic extends User {
    private int resistance;

    public Skeptic(String name, double health, int sanity, int attack, int maxInventorySize, int resistance) {
        super(name, health, sanity, attack, maxInventorySize);
        this.resistance = resistance;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void resistFear() {
        System.out.println(getName() + " is resisting fear with resistance level " + resistance);
    }

    @Override
    public String getRole() {
        return "Skeptic";
    }

    

    @Override
    public String toString() {
        String inventoryDisplay = "[";

        if (getInventorySize() !=0) {
            for (int i = 0; i<getInventorySize()-1; i++){
                inventoryDisplay+= getInventory()[i] +", ";
            }
            inventoryDisplay+= getInventory()[getInventorySize()-1] +"]";
        
        }

        else {
            inventoryDisplay += "]";
        }
        

        return "name='" + getName() + '\'' + "\nhealth=" + getHealth() + "\nsanity=" + getSanity() +"\nattack=" + getAttack() + "\nresistance=" +getResistance()+ "\ninventory=" + inventoryDisplay;
    }
}