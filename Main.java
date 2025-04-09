import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    
        Monsters monster1 = new Bats("Flying Bat", "A dark flying creature.", 50, 10, 5);
        Monsters monster2 = new Doll("Creepy Doll", "A doll with a sinister grin.", 30, 5, 10);
        Monsters monster3 = new Dracula("Vampire Lord", "A bloodthirsty vampire.", 100, 20, 15);
        Monsters monster4 = new Frankenstine("Frankenstein's Monster", "A reanimated corpse.", 80, 15, 10);
        Monsters monster5 = new Ghost("Ghostly Apparition", "A spectral entity.", 40, 10, 20);
        Monsters monster6 = new Joker("The Joker", "A chaotic clown.", 60, 12, 18);
        Monsters monster7 = new Wazoski("Wazoski", "A silly creature.", 20, 5, -5);

   
        ArrayList<Inventory> loot = new ArrayList<>();
        

        
        Room kitchen = new Kitchen("Kitchen", "A room with cooking facilities.", 5, monster1, loot, true, 3);
        Room attic = new Attic("Attic", "A dusty storage space.", 8, monster2, loot, true, true, 6);
        Room basement = new Basement("Basement", "A damp underground area.", 9, monster3, loot, true, 8);
        Room bathroom = new Bathroom("Bathroom", "A room for personal hygiene.", 4, monster4, loot, true, 2);
        Room bedroom = new Bedroom("Bedroom", "A room for rest.", 3, monster5, loot, true, true);
        Room livingRoom = new LivingRoom("Living Room", "A room for relaxation.", 2, monster6, loot, true, false);
        Room nursery = new Nursery("Nursery", "A room for children.", 1, monster7, loot, true, true, 5);

 
        System.out.println(kitchen.toString());
        kitchen.slipOnGrease();

        System.out.println(attic.toString());
        System.out.println("Has Cobwebs: " + attic.hasCobwebs());

        System.out.println(basement.toString());
        basement.checkDampness();

        System.out.println(bathroom.toString());
        bathroom.wipeMirror();

        System.out.println(bedroom.toString());
        bedroom.checkCloset();

        System.out.println(livingRoom.toString());
        livingRoom.turnOnTV();

        System.out.println(nursery.toString());
        nursery.turnOffLullaby();
    }
}
