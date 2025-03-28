public class Healer extends User {
    private int healingAbility; 

    public Healer(String name, double health, int sanity, int speed, int maxInventorySize, int healingAbility) {
        super(name, health, sanity, speed, maxInventorySize);
        this.healingAbility = healingAbility;
    }

    public int getHealingAbility() {
        return healingAbility;
    }

    public void setHealingAbility(int healingAbility) {
        this.healingAbility = healingAbility;
    }

    public void heal(User target) {
        System.out.println(getName() + " is healing " + target.getName() + " by " + healingAbility + " points.");
        target.setHealth(target.getHealth() + healingAbility);
    }
}