public class Keys extends Inventory {
    private int roomUnlock; 
    public Keys(String name, String description, int rarity, int roomUnlock) {
        super(name, description, rarity);
        this.roomUnlock = roomUnlock; 
    }
    
}