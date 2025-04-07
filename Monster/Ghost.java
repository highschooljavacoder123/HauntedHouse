public class Ghost extends Monsters {
    private boolean detectible;

    public Ghost(String name, String description, double health, int damagedealer, int sanitydealer, boolean detectible) {
        super(name, description, health, damagedealer, sanitydealer);
        this.detectible = detectible;
    }

    public boolean isDetectible() {
        return detectible;
    }

    public void setDetectible(boolean detectible) {
        this.detectible = detectible;
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
        return super.toString() + " | Detectible: " + detectible;
    }
}
