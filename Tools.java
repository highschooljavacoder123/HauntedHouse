public class Tools extends Inventory {
    private double durability;
    public Tools (String name, String description, int rarity, double durability) {
        super(name,description,rarity);
        this.durability=durability;
    }
}