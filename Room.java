public class Room {
    private String name; 
    private String description; 
    private int darknessLevel; 
    private Monster[] monsters; 

    public Room(String name, String description, int darknessLevel, Monster[] monsters) {
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

    public Monster[] getMonsters() {
        return monsters; 
    }

    public void setMon
