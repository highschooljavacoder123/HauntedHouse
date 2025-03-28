public class Monsters {
    protected String name;
    protected String description;
    protected int threatlvl;
    protected double health;
    protected int sanitydealer;
    protected int damagedealer;

    public Monsters(String name, String description, int threatlvl, double health, int damagedealer, int sanitydealer) {
        this.name = name;
        this.description = description;
        this.threatlvl = threatlvl;
        this.health = health;
        this.damagedealer = damagedealer;
        this.sanitydealer = sanitydealer;
        
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getThreatlvl() {
        return threatlvl;
    }

    public double getHealth() {
        return health;
    }

    public int getDamagedealer(){
        return damagedealer;
    }
    public int getSanitydealer(){
        return sanitydealer;
    }

    

    
    public void setHealth(double health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public void attack() {
        System.out.println(name + " lunges at you with a terrifying presence!");
    }

    
    public void takeDamage(double damage) {
        this.health -= damage;
        System.out.println(name + " takes " + damage + " damage! Health remaining: " + this.health);
        if (this.health <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }

    
    @Override
    public String toString() {
        return name + " - " + description + "\nThreat Level: " + threatlvl + " | Health: " + health;
    }

}
