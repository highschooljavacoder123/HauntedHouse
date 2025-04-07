public class Doll extends Monsters {
    public Doll(String name, String description, double health, int damagedealer, int sanitydealer) {
        super(name, description, health, damagedealer, sanitydealer);
    }

    @Override
    public void attack() {
        System.out.println(name + " jumps out of bed and screams at you, doing " + sanitydealer + " damage to your sanity!");
    }
    
}
