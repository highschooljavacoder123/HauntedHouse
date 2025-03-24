public class Psychic extends User {
    private int psychicPower; 

    public Psychic(String name, double health, int sanity, int speed, int maxInventorySize, int psychicPower) {
        super(name, health, sanity, speed, maxInventorySize);
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
}