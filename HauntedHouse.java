public class HauntedHouse {
    private Room[][] map;

    public HauntedHouse() {
        setupMap();
    }

    private void setupMap() {
        Monsters inAttic = new Ghost("Ghost", "A mysterious white haunted cloth thats floating around", 25.0, 10, 20, false);

        Monsters inBathroom = new Bats("Blood Thirsty Bats", "A group of bats on the ceiling", 1.0, 5, 0);

        Monsters inBedroom= new Dracula("Dracula", "A scary vampire", 50.0, 0, 10);

        Monsters inNursery = new Doll("Toy doll", "An odd looking toy doll", 1.0, 0, 15);

        Monsters inKitchen = new Wazoski("Mike fricken Wazoski", "A green ball looking thing with one eye",1.0, 0, -10);

        Monsters inLivingroom = new Joker("The Joker", "A crazy clown looking dude", 50.0, 25, 25, 2);

        Monsters inBasement = new Frankenstine("Frankenstine", "A big electrified monster", 100.0, 40, 0, 5);

        
        map = new Room[3][3];

        map[0][0] = new Attic("Creaky Attic","Dust dances in shafts of light piercing through broken boards.",7,inAttic,true,  true,  9);

        map[0][1] = new Bedroom("Old Bedroom","A canopy bed covered in moldy drapes dominates the room.",5,inBedroom,true,false);

        map[0][2] = new Nursery("Ghostly Nursery","Faded wallpaper peels behind a dusty crib and scattered toys.",6,inNursery,true,true,8);

        map[1][2] = new Bathroom(
            "Dripping Bathroom",
            "The mirror is fogged despite the cold air. Water drips rhythmically.",
            4,
            inBathroom,
            true,  
            7       
        );

        map[1][0] = new LivingRoom(
            "Disturbed Living Room",
            "Furniture is overturned, and the TV flickers static on repeat.",
            5,
            inLivingroom,
            true,   
            true   
        );

        map[1][1] = new Kitchen(
            "Greasy Kitchen",
            "Everything is coated in a layer of grime, knives lay scattered.",
            6,
            inKitchen,
            true,  
            8       
        );

        map[2][0] = new Basement("Dark Basement","Wet stone walls and flickering lights create a foreboding atmosphere.",9,inBasement,true, 10);

        
        map[2][1] = null;
        map[2][2] = null;
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
        int cellWidth = 25; // Width of each cell including brackets
    
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                String content;
                if (map[i][j] != null) {
                    content = "[" + map[i][j].getName() + "]";
                } else {
                    content = "[Empty]";
                }
    
                // Make sure each cell is exactly `cellWidth` characters wide
                System.out.print(String.format("%-" + cellWidth + "s", content));
            }
            System.out.println(); // New line after each row
        }
    }
}