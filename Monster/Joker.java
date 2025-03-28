public class Joker extends Monsters {
    private int trickLevel;

    public Joker(String name, String description, double health, int damagedealer, int sanitydealer, int trickLevel) {
        super(name, description, health, damagedealer, sanitydealer);
        this.trickLevel = trickLevel;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    @Override
    public void attack() {
        
        System.out.println(name + " throws a razor-sharp playing card, dealing " + damagedealer + " damage!");
    }

    public void laugh() {
        System.out.println(name + " lets out a maniacal laugh, reducing your sanity by " + sanitydealer + "!");
        trickLevel += 2; // Each laugh makes Joker stronger
    }

    public void trickMove() {
        if (trickLevel >= 10) {
            System.out.println(name + " pulls off a master trick! The next attack will deal double damage!");
            damagedealer *= 2;
            trickLevel = 0; 
        } else {
            System.out.println(name + " is planning something… (Trick Level: " + trickLevel + ")");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Trick Level: " + trickLevel;
    }
}