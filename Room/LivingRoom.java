public class LivingRoom extends Room {
    private boolean hasTV;
    private boolean furnitureMoved;

    public LivingRoom(String name, String description, int darknessLevel, Monsters monsters, boolean hasTV, boolean furnitureMoved) {
        super(name, description, darknessLevel, monsters);
        this.hasTV = hasTV;
        this.furnitureMoved = furnitureMoved;
    }

    public boolean hasTV() {
        return hasTV;
    }

    public void setHasTV(boolean hasTV) {
        this.hasTV = hasTV;
    }

    public boolean isFurnitureMoved() {
        return furnitureMoved;
    }

    public void setFurnitureMoved(boolean furnitureMoved) {
        this.furnitureMoved = furnitureMoved;
    }

    public void turnOnTV() {
        if (hasTV) {
            System.out.println("The TV crackles to life... but no one is holding the remote.");
        } else {
            System.out.println("There is no TV in this room.");
        }
    }
}
