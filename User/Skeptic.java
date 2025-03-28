public class Skeptic extends User {
    private int resistance;

    public Skeptic(String name, double health, int sanity, int speed, int maxInventorySize, int resistance) {
        super(name, health, sanity, speed, maxInventorySize);
        this.resistance = resistance;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void resistFear() {
        System.out.println(getName() + " is resisting fear with resistance level " + resistance);
    }
}