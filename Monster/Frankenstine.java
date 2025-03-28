public class Frankenstine extends Monsters {
    private int electriccharge;

    public Frankenstine(String name, String description, int threatlvl, double health, int damagedealer, int sanitydealer, int electriccharge) {
        super(name, description, threatlvl, health, damagedealer, sanitydealer);
        this.electriccharge = electriccharge;

    }
    public int getElectriccharge() {
        return electriccharge;
    }

    public void setElectriccharge(int electriccharge) {
        this.electriccharge = electriccharge;
    }

    @Override
    public void attack() {
        System.out.println(name + " smashes the ground with immense force, dealing " + damagedealer + " damage!");
        electriccharge += 5;
    }

    public void shockwave() {
        if (electriccharge >= 10) {
            System.out.println(name + " unleashes a powerful electric shockwave, stunning everything nearby!");
            electriccharge -= 10;
        } else {
            System.out.println(name + " doesn't have enough electric charge to use Shockwave!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Electric Charge: " + electriccharge;
    }
}

    
    

