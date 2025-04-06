public class Bathroom extends Room {
    private boolean hasFoggyMirror;
    private int waterLeakLevel;

    public Bathroom(String name, String description, int darknessLevel, Monsters[] monsters, boolean hasFoggyMirror, int waterLeakLevel) {
        super(name, description, darknessLevel, monsters);
        this.hasFoggyMirror = hasFoggyMirror;
        this.waterLeakLevel = waterLeakLevel;
    }

    public boolean hasFoggyMirror() {
        return hasFoggyMirror;
    }

    public void setHasFoggyMirror(boolean hasFoggyMirror) {
        this.hasFoggyMirror = hasFoggyMirror;
    }

    public int getWaterLeakLevel() {
        return waterLeakLevel;
    }

    public void setWaterLeakLevel(int waterLeakLevel) {
        this.waterLeakLevel = waterLeakLevel;
    }

    public void wipeMirror() {
        if (hasFoggyMirror) {
            hasFoggyMirror = false;
            System.out.println("You wipe the mirror... and something seems to be staring back.");
        } else {
            System.out.println("The mirror is already clear.");
        }
    }
}
