public class Kitchen extends Room {
    private boolean hasSharpObjects;
    private int greaseLevel;

    public Kitchen(String name, String description, int darknessLevel, Monsters monsters, boolean hasSharpObjects, int greaseLevel) {
        super(name, description, darknessLevel, monsters);
        this.hasSharpObjects = hasSharpObjects;
        this.greaseLevel = greaseLevel;
    }

    public boolean hasSharpObjects() {
        return hasSharpObjects;
    }

    public void setHasSharpObjects(boolean hasSharpObjects) {
        this.hasSharpObjects = hasSharpObjects;
    }

    public int getGreaseLevel() {
        return greaseLevel;
    }

    public void setGreaseLevel(int greaseLevel) {
        this.greaseLevel = greaseLevel;
    }

    public void slipOnGrease() {
        if (greaseLevel > 5) {
            System.out.println("You slip on the greasy floor! Watch your step!");
        } else {
            System.out.println("The floor is slick, but manageable.");
        }
    }
}
