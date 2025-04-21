import java.util.ArrayList;

public class HauntedHouse {
    private Room[][] map;

    public HauntedHouse() {
        setupMap();
    }

    private void setupMap() {
        Monsters inAttic = new Ghost("Ghost", "A mysterious white haunted cloth thats floating around", 50.0, 0, 20, false);

        Monsters inBathroom = new Bats("Blood Thirsty Bats", "A group of bats on the ceiling", 1.0, 5, 0);

        Monsters inBedroom= new Dracula("Dracula", "A scary vampire", 50.0, 0, 10);

        Monsters inNursery = new Doll("Toy doll", "An odd looking toy doll", 1.0, 0, 15);

        Monsters inKitchen = new Wazoski("Mike fricken Wazoski", "A green ball looking thing with one eye",1.0, 0, -10);

        Monsters inLivingroom = new Joker("The Joker", "A crazy clown looking dude", 50.0, 25, 25, 6);

        Monsters inBasement = new Frankenstine("Frankenstine", "A big electrified monster", 100.0, 40, 0, 5);

        Key unlockAttic = new Key("Attic Key", "This unlocks the attic", "Legendary", "attic");

        Key unlockBasement = new Key("Basement Key", "This unlocks the basement", "Legendary", "basement");

        Key unlockBedroom = new Key("Bedroom Key", "This unlocks the bedroom", "Legendary", "bedroom");

        Key unlockNursery = new Key("Nursery Key", "This unlocks the nursery", "Mythic", "nursery");

        Weapons ghostHunterGun = new Weapons("Ghost Hunter Gun","A specialized firearm only used for banishing ghosts.","Rare",25,"Ranged",4);
        
        Weapons knife = new Weapons("Standard Knife","A basic knife. Not fancy, but it gets the job done.","Common",25,"Melee",5);

        Weapons pitchfork = new Weapons("Pitchfork","An old farming tool, repurposed for defense.","Uncommon",40,"Melee", 3);

        Consumables healingPotion = new Consumables("Healing Potion","A glowing red potion that restores health when consumed.","Common", 0, 100, "0", "100");

        Consumables positivityPotion = new Consumables("Positivity Potion","A potion that makes you more optimistic? It will increase your sanity.","Uncommon", 100, 0, "100", "0");

        Consumables myseriousPotion = new Consumables("A potion?","A glass bottle with no label on it.","Rare", 0, -10,"?", "?");

        Inventory trophy = new Inventory("Trophy", "An award given to those who beat the haunted house", "One in a billion");
        
        ArrayList<Inventory> atticInventories = new ArrayList<>();
        atticInventories.add(unlockBedroom);

        ArrayList<Inventory> bedroomInventories = new ArrayList<>();
        bedroomInventories.add(unlockNursery);
        bedroomInventories.add(healingPotion);

        ArrayList<Inventory> nurseryInventories = new ArrayList<>();
        nurseryInventories.add(unlockBasement);
        nurseryInventories.add(pitchfork);

        ArrayList<Inventory> kitchenInventories = new ArrayList<>();
        kitchenInventories.add(knife);
        kitchenInventories.add(myseriousPotion);

        ArrayList<Inventory> livingroomInventories = new ArrayList<>();
        livingroomInventories.add(positivityPotion);

        ArrayList<Inventory> bathroomInventories = new ArrayList<>();
        bathroomInventories.add(unlockAttic);
        bathroomInventories.add(ghostHunterGun);

        ArrayList<Inventory> basementInventories = new ArrayList<>();
        basementInventories.add(trophy);


        
        map = new Room[3][3];

        map[0][0] = new Attic("Creaky Attic","Dust dances in shafts of light piercing through broken boards.",7,inAttic, atticInventories, true,  true,  9);

        map[0][1] = new Bedroom("Old Bedroom","A canopy bed covered in moldy drapes dominates the room.",5,inBedroom, bedroomInventories, true,false);

        map[0][2] = new Nursery("Ghostly Nursery","Faded wallpaper peels behind a dusty crib and scattered toys.",6,inNursery, nurseryInventories, true,true,8);

        map[1][2] = new Bathroom("Dripping Bathroom","The mirror is fogged despite the cold air. Water drips rhythmically.",4,inBathroom,bathroomInventories,true,  7);

        map[1][1] = new LivingRoom("Disturbed Living Room","The Furniture is overturned, and the TV flickers static on repeat.",5,inLivingroom,livingroomInventories,true,   true);

        map[1][0] = new Kitchen("Greasy Kitchen","Everything is coated in a layer of grime, knives lay scattered.",6,inKitchen,kitchenInventories,true,8);

        map[2][0] = new Basement("Dark Basement","Wet stone walls and flickering lights create a foreboding atmosphere.",9,inBasement,basementInventories,true, 10);

        
        map[2][1] = null;
        map[2][2] = null;

        map[0][0].setLocked(true, "Attic");
        map[0][1].setLocked(true, "Bedroom");
        map[0][2].setLocked(true, "Nursery");
        map[2][0].setLocked(true, "Basement");
    }

    public Room getRoom(int row, int col) {
        if (row < 0 || row >= map.length || col < 0 || col >= map[0].length) {
            return null;
        }
        return map[row][col];
    }

    public Room[][] getMap() {
        return map;
    }

    

    public void printMapLayout() {
        int cellWidth = 30;
    
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                String name = (map[i][j] != null) ? map[i][j].getName() : "Empty";
                String content = "[" + name + "]";
    
                
                while (content.length() < cellWidth) {
                    content += " ";
                }
    
                System.out.print(content);
            }
            System.out.println(); 
        }
    }

    
}