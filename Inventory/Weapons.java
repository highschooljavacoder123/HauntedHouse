public class Weapons extends Inventory {
    private int damage;
    private String combatType; 

    private int usesRemaining;
    public Weapons(String name, String description, String rarity, int damage, String combatType, int usesRemaining) {
        super(name, description, rarity);
        this.damage = damage;
        this.combatType = combatType;
        this.usesRemaining = usesRemaining;
    }

    public Weapons copy() {
        return new Weapons(getName(), getDescription(), getRarity(), damage, combatType, usesRemaining);
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
    public int getUsesRemaining(){
        return usesRemaining;
    }

    public void useWeapon() {
        usesRemaining--;
        System.out.println(getName() + " is used! It deals " + damage + " " + combatType + " damage.");
        

        
        
        
    }

    @Override
    public String toString() {
        return super.toString() + " | Damage: " + damage + " | Combat Type: " + combatType + " | Uses Remaining: "+ usesRemaining;
    }
}