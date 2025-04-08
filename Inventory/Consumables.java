public class Consumables extends Inventory{
    private int usesRemaining; 
    private boolean isCursed; 
    
    public Consumables(String name, String description, String rarity, int usesRemaining, boolean isCursed){
        super(name, description, rarity); 
        this.usesRemaining = usesRemaining; 
        this.isCursed = isCursed; 

    }
    public int getUsesRemaining() {
        return usesRemaining;
    }
    public boolean isCursed(){
        return isCursed; 
    }
    public void setuses(int x){
        usesRemaining = x; 
    }
    public void setCursed(boolean y){
        y = isCursed; 
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
            if (isCursed) {
                System.out.println("A dark energy lingers around you... Was this a mistake?");
            }
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
        if (isCursed) {
            System.out.println("Warning: This item is cursed!");
        }
    }
}
