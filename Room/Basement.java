public class Basement extends Room {
    private boolean hasFlickeringLights;
    private int dampnessLevel; 

    public Basement(String name, String description, int darknessLevel, Monsters[] monsters, boolean hasFlickeringLights, int dampnessLevel) {
        super(name, description, darknessLevel, monsters);
        
        this.hasFlickeringLights = hasFlickeringLights;
        this.dampnessLevel = dampnessLevel;
    }

   


    public boolean hasFlickeringLights() {
        return hasFlickeringLights;
    }

    public void setFlickeringLights(boolean hasFlickeringLights) {
        this.hasFlickeringLights = hasFlickeringLights;
    }

    public int getDampnessLevel() {
        return dampnessLevel;
    }

    public void setDampnessLevel(int dampnessLevel) {
        if (dampnessLevel < 1) {
            this.dampnessLevel = 1;
        } else if (dampnessLevel > 10) {
            this.dampnessLevel = 10;
        } else {
            this.dampnessLevel = dampnessLevel;
        }
    }

  

    public void fixLights() {
        if (hasFlickeringLights) {
            hasFlickeringLights = false;
            System.out.println("You manage to stabilize the lights. The basement feels a little less ominous.");
        } else {
            System.out.println("The lights are already stable.");
        }
    }

    public void checkDampness() {
        System.out.println("You touch the walls and floor...");
        if (dampnessLevel > 7) {
            System.out.println("The basement is soaked with moisture, and the air is thick with the smell of mold.");
        } else if (dampnessLevel > 3) {
            System.out.println("It feels damp, but nothing too concerning.");
        } else {
            System.out.println("The basement is surprisingly dry.");
        }
    }
}
