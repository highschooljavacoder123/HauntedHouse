public class Consumables extends Inventory{
    private int usesRemaining; 
    private int sanityIncrease;
    private int healthIncrease;

    
    
    public Consumables(String name, String description, String rarity, int usesRemaining, int sanityIncrease, int healthIncrease){
        super(name, description, rarity); 
        this.usesRemaining = usesRemaining; 
        this.sanityIncrease = sanityIncrease;
        this.healthIncrease = healthIncrease;
    
    }

    public Consumables copy() {
        return new Consumables(getName(), getDescription(), getRarity(), usesRemaining,  sanityIncrease,  healthIncrease);
    }
    
    public int getUsesRemaining() {
        return usesRemaining;
    }

    public int getSanityIncrease(){
        return sanityIncrease;
    }
    public int getHealthIncrease(){
        return healthIncrease;
    }
    
    public void setuses(int x){
        usesRemaining = x; 
    }
   
    public void setUsesRemaining(int usesRemaining) {
        if (usesRemaining < 0) {
            this.usesRemaining = 0;
        } else {
            this.usesRemaining = usesRemaining;
        }
    }
    public void useItem() {
        if (usesRemaining > 0) {
            usesRemaining--;
            System.out.println("You used " + getName() + ". Uses remaining: " + usesRemaining);
            System.out.println("The "+getName()+" increased your health by "+healthIncrease+" and increased your sanity by "+sanityIncrease);
            

        } 
        else {
            System.out.println("The " + getName() + " has been fully consumed and can no longer be used.");
        }
    }

    public void inspectItem() {
        System.out.println("Item: " + getName());
        System.out.println("Description: " + getDescription());
        System.out.println("Rarity Level: " + getRarity());
        System.out.println("Uses Remaining: " + usesRemaining);
        
    }
}
