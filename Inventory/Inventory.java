public class Inventory{
    public static final String BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
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
    public static void printBlue(String x){
        System.out.println(BLUE + x + ANSI_RESET);
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
        return "Name: " + BLUE + name + ANSI_RESET + " | Rarity: " + rarity;
    }
    
    
}