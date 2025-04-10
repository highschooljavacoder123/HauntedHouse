public class Monsters {
    protected String name;
    protected String description;

    protected double health;
    protected double sanitydealer;
    protected int damagedealer;

    public Monsters(String name, String description, double health, int damagedealer, double sanitydealer) {
        this.name = name;
        this.description = description;
        
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

   

    public double getHealth() {
        if (health<0) {
            return 0.0;
        }
        return health;
    }

    public int getDamagedealer(){
        return damagedealer;
    }
    public double getSanitydealer(){
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
        if (this.health < 0){
            this.health = 0;
        }
        System.out.println(name + " takes " + damage + " damage! Health remaining: " + this.health);
        if (this.health <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }

    
    @Override
    public String toString() {
        return name + " - " + description +  " | Health: " + health;
    }

}
