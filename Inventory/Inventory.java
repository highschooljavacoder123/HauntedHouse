public class Inventory{
    private String name;
    private String description;
    private String rarity;
    public Inventory(String name, String description, String rarity){
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
    public String getRarity(){
        return rarity;
    }
}