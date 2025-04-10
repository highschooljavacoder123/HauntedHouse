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
            // System.out.println("You are currently at the " + hauntedhouse.getRoom(playerRow, playerCol).getName());

            // if (hauntedhouse.getRoom(playerRow,playerCol).getName().equals("Greasy Kitchen")) {
            //     if (!hauntedhouse.getRoom(playerRow,playerCol).isMonsterDefeated()) {

            //         System.out.println("Suddenly, a monster appears! It looks odd, what is that?");
            //         pause(5000);
            //         hauntedhouse.getRoom(playerRow, playerCol).getMonsters().attack();

            //         player.setHealth(player.getHealth()-hauntedhouse.getRoom(playerRow,playerCol).getMonsters().getDamagedealer());
            //         player.setSanity(player.getSanity()-hauntedhouse.getRoom(playerRow, playerCol).getMonsters().getSanitydealer());

            //         System.out.println(player);

                    
            //         System.out.println("You found some items in the room:" + hauntedhouse.getRoom(playerRow, playerCol).displayInventory());
            //         System.out.println();
            //         pause(1000);
            //         System.out.println("You pick them up");

                        
            //         for (int i = 0; i < hauntedhouse.getRoom(playerRow, playerCol).getInventory().size(); i++) {
            //             Inventory original = hauntedhouse.getRoom(playerRow, playerCol).getSpecificInventory(i);
            //             Inventory copy = copyInventoryItem(original);
            //             player.addItemToInventory(copy);
            //         }
            //         hauntedhouse.getRoom(playerRow, playerCol).clearInventory();
            //         player.printInventory();

            //         hauntedhouse.getRoom(playerRow,playerCol).setMonsterDefeated();

            //     }
            // }

            // if (hauntedhouse.getRoom(playerRow, playerCol).getName().equals("Disturbed Living Room")) {
            //     System.out.println(hauntedhouse.getRoom(playerRow,playerCol).getDescription());

            //     System.out.println();

            //     if (!hauntedhouse.getRoom(playerRow, playerCol).isMonsterDefeated()) {
            //         System.out.println("You see "+ hauntedhouse.getRoom(playerRow,playerCol).getMonsters().getDescription());
            //         boolean yesno = true;
            //         while (yesno) {
            //             player.printInventory();
            //             System.out.println("You can use one item from your inventory. Do you want to?");
            //             System.out.println("1: Yes");
            //             System.out.println("2: No");

            //             int use = thegame.nextInt();
            //             thegame.nextLine();
            //             System.out.println();

            //             if (use == 1) {
            //                 player.printInventory();
            //                 System.out.println("Enter the name of the item you want to use:");
            //                 String itemName = thegame.nextLine();

            //                 Inventory itemToUse = player.getItemByName(itemName); 
            //                 if (itemToUse == null) {
            //                     System.out.println("That item isn't in your inventory.");
            //                 } else {
            //                     if (itemToUse instanceof Consumables) {
            //                         ((Consumables) itemToUse).useItem();
            //                         System.out.println();
            //                         yesno=false;
            //                     } else if (itemToUse instanceof Weapons) {
            //                         ((Weapons) itemToUse).useWeapon();
            //                         System.out.println();
            //                         yesno=false;
            //                     } else {
            //                         System.out.println("That item can't be used.");
            //                     }
            //                 }
            //             } else if (use == 2) {
            //                 yesno = false;
            //             } else {
            //                 System.out.println("Invalid input. Please enter 1 or 2.");
            //             }
            //         }
                    
            //         while (hauntedhouse.getRoom(playerRow,playerCol).getMonsters().getHealth()>=0) {
            //             System.out.println();
            //         }
            //         hauntedhouse.getRoom(playerRow, playerCol).getMonsters().attack();
            //         hauntedhouse.getRoom(playerRow, playerCol).setMonsterDefeated();
            
            //         System.out.println("You found some items in the room: " + hauntedhouse.getRoom(playerRow, playerCol).displayInventory());
            //         for (int i = 0; i < hauntedhouse.getRoom(playerRow, playerCol).getInventory().size(); i++) {
            //             Inventory original = hauntedhouse.getRoom(playerRow, playerCol).getSpecificInventory(i);
            //             Inventory copy = copyInventoryItem(original);
            //             player.addItemToInventory(copy);
            //         }
            //         hauntedhouse.getRoom(playerRow, playerCol).clearInventory();
                    

                    
                    

                    
                    
                    
            //     }

            
            
                
            //}
            Room currentRoom = hauntedhouse.getRoom(playerRow, playerCol);
            System.out.println("You are currently at the " + currentRoom.getName());
            handleRoomEvents(currentRoom, player, thegame);
            
                    
            
                    
                
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
    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }



    public static void handleRoomEvents(Room room, User player, Scanner input) {
        System.out.println(room.getDescription());
        System.out.println();
    
        Monsters monster = room.getMonsters();
    
        if (!room.isMonsterDefeated()) {
            System.out.println("You see " + monster.getDescription());
    
            // Show subclass-based special actions
            if (monster instanceof Joker) {
                ((Joker) monster).laugh();
                ((Joker) monster).trickMove();
            } else if (monster instanceof Ghost) {
                ((Ghost) monster).phaseShift();
            } else if (monster instanceof Frankenstine) {
                ((Frankenstine) monster).shockwave();
            }
    
            
            while (monster.getHealth() > 0 && player.getHealth() > 0) {
                System.out.println("\nYour turn! What would you like to do?");
                System.out.println("1: Use a weapon");
                System.out.println("2: Use a consumable");
                System.out.println("3: Punch the monster (basic melee attack)");
            
                String action = input.nextLine();
            
                if (action.equals("1")) {
                    player.printInventory();
                    System.out.println("Enter the name of the weapon:");
                    String weaponName = input.nextLine();
                    Inventory itemToUse = player.getItemByName(weaponName);
            
                    if (itemToUse instanceof Weapons) {
                        Weapons weapon = (Weapons) itemToUse;
                        weapon.useWeapon();
                        monster.takeDamage(weapon.getDamage());
                    } else {
                        System.out.println("That's not a usable weapon.");
                    }
            
                } else if (action.equals("2")) {
                    player.printInventory();
                    System.out.println("Enter the name of the consumable:");
                    String consumableName = input.nextLine();
                    Inventory itemToUse = player.getItemByName(consumableName);
            
                    if (itemToUse instanceof Consumables) {
                        ((Consumables) itemToUse).useItem();
                    } else {
                        System.out.println("That's not a usable consumable.");
                    }
            
                } else if (action.equals("3")) {
                    System.out.println("You throw a punch!");
                    int punchDamage = 5;
                    monster.takeDamage(punchDamage);
                    System.out.println("You deal " + punchDamage + " damage with your fists.");
                } else {
                    System.out.println("Invalid action. Try again.");
                    continue;
                }
            
                // Monster's turn
                if (monster.getHealth() > 0) {
                    System.out.println("\n" + monster.getName() + "'s turn!");
                    if (monster instanceof Joker) {
                        ((Joker) monster).laugh();
                        ((Joker) monster).trickMove();
                    } else if (monster instanceof Ghost) {
                        ((Ghost) monster).phaseShift();
                    } else if (monster instanceof Frankenstine) {
                        ((Frankenstine) monster).shockwave();
                    }
            
                    monster.attack();
                    player.setHealth(player.getHealth() - monster.getDamagedealer());
                    player.setSanity(player.getSanity() - monster.getSanitydealer());
            
                    System.out.println("Your health: " + player.getHealth());
                    System.out.println("Your sanity: " + player.getSanity());
            
                    if (player.getHealth() <= 0) {
                        System.out.println("You have been defeated... The house claims another soul.");
                        System.exit(0);
                    }
                }
            }
    
           
            System.out.println("You found some items in the room: " + room.displayInventory());
            for (int i = 0; i < room.getInventory().size(); i++) {
                Inventory original = room.getSpecificInventory(i);
                Inventory copy = copyInventoryItem(original);
                player.addItemToInventory(copy);
            }
            room.clearInventory();
        }
    }
}


