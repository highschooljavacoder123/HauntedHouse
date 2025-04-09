import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User player = null;
        int playerCol = 0;
        int playerRow = 1;
        Scanner thegame = new Scanner(System.in);

        System.out.println("Please enter your name");
        String name = thegame.nextLine();

        boolean advance = false;
        while (!advance) {
            System.out.println("Pick a role to play: Ghost Hunter, Psychic, Skeptic, or Healer");
            String roleinput = thegame.nextLine();

            if (roleinput.toLowerCase().contains("psychic")) {
                player = new Psychic(name, 250, 100, 5, 5, 5);
                advance = true;
            } else if (roleinput.toLowerCase().contains("ghosthunter") || roleinput.toLowerCase().contains("ghost hunter")) {
                player = new Ghosthunter(name, 300, 100, 0, 5);
                advance = true;
            } else if (roleinput.toLowerCase().contains("healer")) {
                player = new Healer(name, 200, 100, 5, 5, 5);
                advance = true;
            } else if (roleinput.toLowerCase().contains("skeptic")) {
                player = new Skeptic(name, 250, 100, 5, 5, 5);
                advance = true;
            } else {
                System.out.println("Invalid role");
            }
        }

        HauntedHouse hauntedhouse = new HauntedHouse();

        System.out.println("Hello there " + player.getName() + ". You might be a " + player.getRole() + " but have you got the guts to survive?");
        System.out.println();
        System.out.println(player);

        boolean loss = false;

        while (!loss) {
            hauntedhouse.printMapLayout();
            System.out.println("You are currently at the " + hauntedhouse.getRoom(playerRow, playerCol).getName());

            if (hauntedhouse.getRoom(playerRow,playerCol).getName().equals("Greasy Kitchen")) {
                if (!hauntedhouse.getRoom(playerRow,playerCol).isMonsterDefeated()) {
                    System.out.println("Suddenly, a monster appears! It looks odd, what is that?");
                    hauntedhouse.getRoom(playerRow, playerCol).getMonsters().attack();

                    player.setHealth(player.getHealth()-hauntedhouse.getRoom(playerRow,playerCol).getMonsters().getDamagedealer());
                    player.setSanity(player.getSanity()-hauntedhouse.getRoom(playerRow, playerCol).getMonsters().getSanitydealer());

                    System.out.println(player);

                    
                    System.out.println("You found some items in the room:" + hauntedhouse.getRoom(playerRow, playerCol).displayInventory());
                    System.out.println();
                    System.out.println("You pick them up");

                        
                    for (int i = 0; i < 2; i++) {
                        Inventory original = hauntedhouse.getRoom(playerRow, playerCol).getSpecificInventory(i);
                        Inventory copy = copyInventoryItem(original);
                        player.addItemToInventory(copy);
                    }
                    hauntedhouse.getRoom(playerRow, playerCol).clearInventory();
                    player.printInventory();

                    hauntedhouse.getRoom(playerRow,playerCol).setMonsterDefeated();

                }
            }

            if (hauntedhouse.getRoom(playerRow, playerCol).getName().equals("Disturbed Living Room")) {
                System.out.println("The TV flickers with static and strange whispers.");
                if (!hauntedhouse.getRoom(playerRow, playerCol).isMonsterDefeated()) {
                    System.out.println("The Joker lunges from behind the couch with a cackle!");
                    hauntedhouse.getRoom(playerRow, playerCol).getMonsters().attack();
                    hauntedhouse.getRoom(playerRow, playerCol).setMonsterDefeated();
            
                    System.out.println("You found some items in the room: " + hauntedhouse.getRoom(playerRow, playerCol).displayInventory());
                    for (int i = 0; i < hauntedhouse.getRoom(playerRow, playerCol).getInventory().size(); i++) {
                        Inventory original = hauntedhouse.getRoom(playerRow, playerCol).getSpecificInventory(i);
                        Inventory copy = copyInventoryItem(original);
                        player.addItemToInventory(copy);
                    }
                    hauntedhouse.getRoom(playerRow, playerCol).clearInventory();
                    player.printInventory();
                }
            
                
            }
            
                    
            
                    
                
            boolean moved = false;
            System.out.println();

            while (!moved) {
                System.out.println("Which direction would you like to move? (up/down/left/right)");
                String direction = thegame.nextLine();
                int[] newPos = player.move(direction, playerRow, playerCol, hauntedhouse.getMap());

                // Only update if the player actually moved
                if (newPos[0] != playerRow || newPos[1] != playerCol) {
                    playerRow = newPos[0];
                    playerCol = newPos[1];
                    moved = true;
                } else {
                    System.out.println("You remain in the same room. Try a different direction.");
                }
            }
            
            
            
        }
        thegame.close();
    }
        
    

    private static Inventory copyInventoryItem(Inventory original) {
        if (original instanceof Weapons) {
            Weapons w = (Weapons) original;
            return new Weapons(w.getName(), w.getDescription(), w.getRarity(), w.getDamage(), w.getType());
        } else if (original instanceof Consumables) {
            Consumables c = (Consumables) original;
            return new Consumables(c.getName(), c.getDescription(), c.getRarity(), c.getUsesRemaining());
        } else if (original instanceof Key) {
            Key k = (Key) original;
            Key copy = new Key(k.getName(), k.getDescription(), k.getRarity(), k.getRoomName());
            if (k.isUsed()) copy.useKey();
            return copy;
        } else {
            return new Inventory(original.getName(), original.getDescription(), original.getRarity());
        }
    }
}
