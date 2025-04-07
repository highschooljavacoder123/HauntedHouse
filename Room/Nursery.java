public class Nursery extends Room {
    private boolean hasLullabyMusic;
    private boolean hasRockingChair;
    private int toyScatteringLevel; 

    public Nursery(String name, String description, int darknessLevel, Monsters monsters, boolean hasLullabyMusic, boolean hasRockingChair, int toyScatteringLevel) {
        super(name, description, darknessLevel, monsters);
        this.hasLullabyMusic = hasLullabyMusic;
        this.hasRockingChair = hasRockingChair;
        this.toyScatteringLevel = toyScatteringLevel;
    }

    public boolean hasLullabyMusic() {
        return hasLullabyMusic;
    }

    public void setLullabyMusic(boolean hasLullabyMusic) {
        this.hasLullabyMusic = hasLullabyMusic;
    }

    public boolean hasRockingChair() {
        return hasRockingChair;
    }

    public void setRockingChair(boolean hasRockingChair) {
        this.hasRockingChair = hasRockingChair;
    }

    public int getToyScatteringLevel() {
        return toyScatteringLevel;
    }

    public void setToyScatteringLevel(int toyScatteringLevel) {
        if (toyScatteringLevel < 1) {
            this.toyScatteringLevel = 1;
        } else if (toyScatteringLevel > 10) {
            this.toyScatteringLevel = 10;
        } else {
            this.toyScatteringLevel = toyScatteringLevel;
        }
    }


    public void turnOffLullaby() {
        if (hasLullabyMusic) {
            hasLullabyMusic = false;
            System.out.println("The eerie lullaby fades into silence. The room feels calmer... for now.");
        } else {
            System.out.println("There’s no music playing.");
        }
    }

    public void checkRockingChair() {
        if (hasRockingChair) {
            System.out.println("The rocking chair sits eerily still... until it suddenly creaks forward on its own!");
        } else {
            System.out.println("There’s no rocking chair here.");
        }
    }

    public void cleanUpToys() {
        if (toyScatteringLevel > 0) {
            System.out.println("You carefully gather up the scattered toys.");
            toyScatteringLevel = 0;
        } else {
            System.out.println("The nursery is already tidy.");
        }
    }
}
