public class Room {
    private String name; 
    private String description; 
    private int darknessLevel; 
    private Monsters monsters; 
    private Inventory[] loot;

    public Room(String name, String description, int darknessLevel, Monsters monsters, Inventory[] loot) {
        this.name = name; 
        this.description = description; 
        this.darknessLevel = darknessLevel; 
        this.monsters = monsters; 
        this.loot = loot;
    }

    public String getName() {
        return name; 
    }

    public String getDescription() {
        return description; 
    }

    public int getDarknessLevel() {
        return darknessLevel; 
    }

    public void setName(String name) {
        this.name = name; 
    }

    public void setDescription(String description) {
        this.description = description; 
    }

    public void setDarknessLevel(int darknessLevel) {
        this.darknessLevel = darknessLevel; 
    }

    public Monsters getMonsters() {
        return monsters; 
    }

    public Inventory[] getInventory() {
        return loot;
    }

    public String displayInventory() {
        String output = "[";
        for (int i = 0; i<loot.length-1; i++) {
            output += i+": "+loot[i].getName() + ", ";
        }
        return output + (loot.length-1)+ ": "+loot[loot.length-1].getName() +"]";

    }

}
