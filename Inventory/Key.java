public class Key extends Inventory {
    private String roomUnlock;
    private boolean isUsed;

    public Key(String name, String description, String rarity, String roomUnlock) {
        super(name, description, rarity);
        this.roomUnlock = roomUnlock;
        this.isUsed = false;
    }

    public Key copy() {
        return new Key(getName(), getDescription(), getRarity(), roomUnlock);
    }

    public String getRoomName() {
        return roomUnlock;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void useKey() {
        isUsed = true;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " It unlocks the " + roomUnlock + ".";
    }
}