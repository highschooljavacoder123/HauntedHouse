public class Monsters {
    private String name;
    private String description;
    private int threatlvl;
    private double health;
    
    private int sanitydealer;

    public Monsters(String name, String description, int threatlvl, double health) {
        this.name = name;
        this.description = description;
        this.threatlvl = threatlvl;
        this.health = health;
        
        
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

    // ToString Method
    @Override
    public String toString() {
        return name + " - " + description + "\nThreat Level: " + threatlvl + " | Health: " + health;
    }

}
