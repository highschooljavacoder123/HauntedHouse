public class Dracula extends Monsters {
    public Dracula(String name, String description, double health, int damagedealer, int sanitydealer) {
       super(name, description, health, damagedealer, sanitydealer);
       
    }

    @Override
    public void attack() {
        System.out.println(name + " talks about his life issues for an hour and drives you insane and does" + sanitydealer + " damage to your sanity!");
    }

    
    
}

