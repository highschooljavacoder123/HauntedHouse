import java.util.ArrayList;

public class Room {
    private String name; 
    private String description; 
    private int darknessLevel; 
    private Monsters monsters; 
    private ArrayList<Inventory> loot;  
    private boolean isLocked = false;
    private String requiredKeyName = "";
    private boolean isMonsterDefeated;


    public Room(String name, String description, int darknessLevel, Monsters monsters, ArrayList<Inventory> loot) {
        this.name = name; 
        this.description = description; 
        this.darknessLevel = darknessLevel; 
        this.monsters = monsters; 
        this.loot = loot;
        this.isMonsterDefeated = false;
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

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked, String requiredKeyName) {
        this.isLocked = locked;
        this.requiredKeyName = requiredKeyName;
    }

    public String getRequiredKeyName() {
        return requiredKeyName;
    }

    public boolean isMonsterDefeated(){
        return this.isMonsterDefeated;
    }

    public void setDescription(String description) {
        this.description = description; 
    }

    public void setDarknessLevel(int darknessLevel) {
        this.darknessLevel = darknessLevel; 
    }

    public void setMonsterDefeated() {
        this.isMonsterDefeated = true;
    }

    public Monsters getMonsters() {
        return monsters; 
    }

    public ArrayList<Inventory> getInventory() {
        return loot;
    }

    public Inventory getSpecificInventory(int x) {
        return loot.get(x);
    }

    public void deleteSpecificInventory(int x) {
        loot.remove(x);
    }

    public String displayInventory() {
        if (loot.isEmpty()) {
            return "[]";
        }

        String output = "[";
        for (int i = 0; i < loot.size(); i++) {
            output += i + ": " + loot.get(i).getName();
            if (i < loot.size() - 1) {
                output += ", ";
            }
        }
        return output + "]";
    }
    public void clearInventory() {
        this.loot.clear();
    }

    
}
