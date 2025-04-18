import java.util.ArrayList;
public class Attic extends Room {
    private boolean hasCobwebs;
    private boolean isHaunted;
    private int creakingLevel; 

    public Attic(String name, String description, int darknessLevel, Monsters monsters, ArrayList<Inventory> loot, boolean hasCobwebs, boolean isHaunted, int creakingLevel) {
        super(name, description, darknessLevel, monsters, loot);
        this.hasCobwebs = hasCobwebs;
        this.isHaunted = isHaunted;
        this.creakingLevel = creakingLevel;
    }

    public boolean hasCobwebs() {
        return hasCobwebs;
    }

    public void setHasCobwebs(boolean hasCobwebs) {
        this.hasCobwebs = hasCobwebs;
    }

    public boolean isHaunted() {
        return isHaunted;
    }

    public void setHaunted(boolean haunted) {
        isHaunted = haunted;
    }

    public int getCreakingLevel() {
        return creakingLevel;
    }

    // public void setCreakingLevel(int creakingLevel) {
    //     if (creakingLevel < 1) {
    //         this.creakingLevel = 1;
    //     } else if (creakingLevel > 10) {
    //         this.creakingLevel = 10;
    //     } else {
    //         this.creaking(); 
    //     }
    // }
}
