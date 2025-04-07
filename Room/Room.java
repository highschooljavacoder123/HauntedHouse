public class Room {
    private String name; 
    private String description; 
    private int darknessLevel; 
    private Monsters monsters; 

    public Room(String name, String description, int darknessLevel, Monsters monsters) {
        this.name = name; 
        this.description = description; 
        this.darknessLevel = darknessLevel; 
        this.monsters = monsters; 
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

}
