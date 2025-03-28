public class Ghost extends Monsters {
    private int hauntLevel;

    public Ghost(String name, String description, double health, int damagedealer, int sanitydealer, int hauntLevel) {
        super(name, description, health, damagedealer, sanitydealer);
        this.hauntLevel = hauntLevel;
    }

    public int getHauntLevel() {
        return hauntLevel;
    }

    public void setHauntLevel(int hauntLevel) {
        this.hauntLevel = hauntLevel;
    }

    @Override
    public void attack() {
        System.out.println(name + " whispers chilling words into your mind, draining " + sanitydealer + " sanity!");
    }

    public void phaseShift() {
        System.out.println(name + " becomes intangible, avoiding all attacks for one turn!");
    }

    @Override
    public String toString() {
        return super.toString() + " | Haunt Level: " + hauntLevel;
    }
}
