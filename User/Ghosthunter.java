public class Ghosthunter extends User {
    
    

    public Ghosthunter(String name, double health, int sanity, int attack, int maxInventorySize) {
        super(name, health, sanity, attack, maxInventorySize);
        
    }





    
    public void attackGhost(String ghostName) {
        System.out.println(getName() + " attacks " + ghostName + " dealing " + (getAttack()+30)  + " damage!");
    }

    @Override
    public String getRole(){
        return "Ghost Hunter";
    }



    
}