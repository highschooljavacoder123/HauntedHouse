public class Healer extends User {
    private int healingAbility; 

    public Healer(String name, double health, int sanity, int attack, int maxInventorySize, int healingAbility) {
        super(name, health, sanity, attack, maxInventorySize);
        this.healingAbility = healingAbility;
    }

    public int getHealingAbility() {
        return healingAbility;
    }

    public void setHealingAbility(int healingAbility) {
        this.healingAbility = healingAbility;
    }

    public void heal() {
        System.out.println(getName() + " is healing by " +getHealingAbility() + "hp");
        this.healingAbility+=10;
    }

    @Override
    public String getRole(){
        return "Healer";
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
        

        return "name='" + getName() + '\'' + "\nhealth=" + getHealth() + "\nsanity=" + getSanity() +"\nattack=" + getAttack() + "\nhealing=" +getHealingAbility()+ "\ninventory=" + inventoryDisplay;
    }
}