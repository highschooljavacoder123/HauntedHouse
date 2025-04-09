import java.util.ArrayList;
public class Bedroom extends Room {
    private boolean bedUnmade;
    private boolean hasCloset;

    public Bedroom(String name, String description, int darknessLevel, Monsters monsters, ArrayList<Inventory> loot, boolean bedUnmade, boolean hasCloset) {
        super(name, description, darknessLevel, monsters, loot);
        this.bedUnmade = bedUnmade;
        this.hasCloset = hasCloset;
    }

    public boolean isBedUnmade() {
        return bedUnmade;
    }

    public void setBedUnmade(boolean bedUnmade) {
        this.bedUnmade = bedUnmade;
    }

    public boolean hasCloset() {
        return hasCloset;
    }

    public void setHasCloset(boolean hasCloset) {
        this.hasCloset = hasCloset;
    }

    public void checkCloset() {
        if (hasCloset) {
            System.out.println("You slowly open the closet... something shifts in the darkness.");
        } else {
            System.out.println("There’s no closet in this room.");
        }
    }
}
