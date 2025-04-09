public class Inventory{
    private String name;
    private String description;
    private String rarity;
    public Inventory(String name, String description, String rarity){
        this.name = name;
        this.description = description;
        this.rarity = rarity;
    }

    public Inventory(Inventory other) {
        this.name = other.name;
        this.description = other.description;
        this.rarity = other.rarity;
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

    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setRarity(String rarity){
        this.rarity = rarity;
    }
    @Override
    public String toString() {
        return "Name: " + name + " | Description: " + description + " | Rarity: " + rarity;
    }
    
    
}