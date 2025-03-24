public class Inventory{
    private String name;
    private String description;
    private int rarity;
    public Inventory(String name, String description, int rarity){
        this.name = name;
        this.description = description;
        this.rarity = rarity;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getRarity(){
        return rarity;
    }
}