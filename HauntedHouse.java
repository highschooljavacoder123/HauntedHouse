public class HauntedHouse {
    private Room[][] map;

    public HauntedHouse() {
        setupMap();
    }

    private void setupMap() {
        map = new Room[3][3];

        map[0][0] = new Attic("Creaky Attic","Dust dances in shafts of light piercing through broken boards.",7,new Monsters[]{},true,  true,  9);

        map[0][1] = new Bedroom("Old Bedroom","A canopy bed covered in moldy drapes dominates the room.",5,new Monsters[]{},true,false);

        map[0][2] = new Nursery("Ghostly Nursery","Faded wallpaper peels behind a dusty crib and scattered toys.",6,new Monsters[]{},true,true,8);

        map[1][2] = new Bathroom(
            "Dripping Bathroom",
            "The mirror is fogged despite the cold air. Water drips rhythmically.",
            4,
            new Monsters[]{},
            true,   // hasFoggyMirror
            7       // waterLeakLevel
        );

        map[1][0] = new LivingRoom(
            "Disturbed Living Room",
            "Furniture is overturned, and the TV flickers static on repeat.",
            5,
            new Monsters[]{},
            true,   // hasTV
            true    // furnitureMoved
        );

        map[1][1] = new Kitchen(
            "Greasy Kitchen",
            "Everything is coated in a layer of grime, knives lay scattered.",
            6,
            new Monsters[]{},
            true,   // hasSharpObjects
            8       // greaseLevel
        );

        map[2][0] = new Basement("Dark Basement","Wet stone walls and flickering lights create a foreboding atmosphere.",9,new Monsters[]{},true, 10);

        
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