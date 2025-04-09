public class Psychic extends User {
    private int psychicPower; 

    public Psychic(String name, double health, int sanity, int attack, int maxInventorySize, int psychicPower) {
        super(name, health, sanity, attack, maxInventorySize);
        this.psychicPower = psychicPower;
    }

    public int getPsychicPower() {
        return psychicPower;
    }

    public void setPsychicPower(int psychicPower) {
        this.psychicPower = psychicPower;
    }

    public void senseGhostPresence() {
        System.out.println(getName() + " senses ghostly energy using psychic power level " + psychicPower);
    }

    public void calmGhost(String ghostName) {
        System.out.println(getName() + " attempts to calm " + ghostName + " with psychic energy.");
    }

    @Override
    public String getRole(){
        return "Psychic";
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
        

        return "name='" + getName() + '\'' + "\nhealth=" + getHealth() + "\nsanity=" + getSanity() +"\nattack=" + getAttack() + "\npsychic power=" +getPsychicPower()+ "\ninventory=" + inventoryDisplay;
    }
}