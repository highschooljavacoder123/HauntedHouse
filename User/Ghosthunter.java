public class Ghosthunter extends User {
    private int ghostDetectionLevel;
    private int attackPower;

    public Ghosthunter(String name, double health, int sanity, int speed, int maxInventorySize, int ghostDetectionLevel, int attackPower) {
        super(name, health, sanity, speed, maxInventorySize);
        this.ghostDetectionLevel = ghostDetectionLevel;
        this.attackPower = attackPower;
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