public class Bats extends Monsters {
    public Bats(String name, String description, double health, int damagedealer, int sanitydealer) {
        super(name, description, health, damagedealer, sanitydealer);
    }

    @Override
    public void attack() {
        System.out.println(name + " flies at you and deals " + damagedealer + " damage!");
    }

    @Override
    public String toString() {
        return super.toString();

    }

    

    
}
