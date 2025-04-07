public class Ghosthunter extends User {
    private int ghostDetectionLevel;
    private int attackPower;

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

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void attackGhost(String ghostName) {
        System.out.println(getName() + " attacks " + ghostName + " dealing " + attackPower + " damage!");
    }
}