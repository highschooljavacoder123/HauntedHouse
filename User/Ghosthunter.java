public class Ghosthunter extends User {
    private int ghostDetectionLevel;
    

    public Ghosthunter(String name, double health, int sanity, int attack, int maxInventorySize, int ghostDetectionLevel) {
        super(name, health, sanity, attack, maxInventorySize);
        this.ghostDetectionLevel = ghostDetectionLevel;
    }

    public int getGhostDetectionLevel() {
        return ghostDetectionLevel;
    }

    public void setGhostDetectionLevel(int ghostDetectionLevel) {
        this.ghostDetectionLevel = ghostDetectionLevel;
    }

    

    

    public void attackGhost(String ghostName) {
        System.out.println(getName() + " attacks " + ghostName + " dealing " + getAttack() + " damage!");
    }

    @Override
    public String getRole(){
        return "Ghost Hunter";
    }
}