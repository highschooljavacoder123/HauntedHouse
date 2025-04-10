public class Consumables extends Inventory{
    
    private int sanityIncrease;
    private int healthIncrease;
    private String justformystery1;
    private String justformysery2;

    
    
    public Consumables(String name, String description, String rarity, int sanityIncrease, int healthIncrease , String justformystery1, String justformystery2){
        super(name, description, rarity); 
         
        this.sanityIncrease = sanityIncrease;
        this.healthIncrease = healthIncrease;
        this.justformystery1 = justformystery1;
        this.justformysery2 = justformystery2;
    
    }

    public Consumables copy() {
        return new Consumables(getName(), getDescription(), getRarity(),  sanityIncrease,  healthIncrease, justformystery1, justformysery2);
    }
    
    

    public int getSanityIncrease(){
        return sanityIncrease;
    }
    public int getHealthIncrease(){
        return healthIncrease;
    }

    public String getjustformystery1(){
        return justformystery1;
    }
    public String getjustformystery2(){
        return justformysery2;
    }
    
    
   
    
    public void useItem() {
        
            System.out.println("You used " + getName());
            System.out.println("The "+getName()+" increased your health by "+healthIncrease+" and increased your sanity by "+sanityIncrease);
            

        
    }

    public void inspectItem() {
        System.out.println("Item: " + getName());
        System.out.println("Description: " + getDescription());
        System.out.println("Rarity Level: " + getRarity());
        
        
    }
    @Override 
    public String toString() {
        return super.toString() + " | Sanity increase: " + justformystery1 + " | Health increase: " + justformysery2;
    }
}
