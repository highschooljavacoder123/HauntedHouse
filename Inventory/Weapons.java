public class Weapons extends Inventory {
    private int damage;
    private String combatType; 

    public Weapons(String name, String description, String rarity, int damage, String combatType) {
        super(name, description, rarity);
        this.damage = damage;
        this.combatType = combatType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0) {
            this.damage = 0;
        } else {
            this.damage = damage;
        }
    }

    public String getType() {
        return combatType;
    }

    public void setType(String type) {
        this.combatType = type;
    }

    public void useWeapon() {
        System.out.println(getName() + " is used! It deals " + damage + " " + combatType + " damage.");
    }

    @Override
    public String toString() {
        return getName() + " - " + getDescription() + " | Type: " + combatType + " | Damage: " + damage + " | Rarity: " + getRarity();
    }
}