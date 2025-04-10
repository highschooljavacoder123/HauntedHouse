public class Wazoski extends Monsters{
    public Wazoski(String name, String description, double health, int damagedealer, int sanitydealer) {
        super(name,description,health,damagedealer,sanitydealer);

    }

    @Override
    public void attack() {
        System.out.println(name + " tries to scare you but instead makes you laugh, increasing your sanity by " + -sanitydealer);
        
        
    }

}
