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
            System.out.println("Pick a role to play: Ghost Hunter, Skeptic, or Healer");
            String roleinput = thegame.nextLine();

            
            if (roleinput.toLowerCase().contains("ghosthunter") || roleinput.toLowerCase().contains("ghost hunter")) {
                player = new Ghosthunter(name, 300, 100, 0, 50);
                advance = true;
            } 
            else if (roleinput.toLowerCase().contains("healer")) {
                player = new Healer(name, 200, 100, 5, 50, 10);
                advance = true;
            } 
            else if (roleinput.toLowerCase().contains("skeptic")) {
                player = new Skeptic(name, 250, 100, 5, 50, 2);
                advance = true;
            } 
            else {
                System.out.println("Invalid role");
            }
        }

        HauntedHouse hauntedhouse = new HauntedHouse();

        System.out.println("Hello there " + player.getName() + ". You might be a " + player.getRole() + " but have you got the guts to survive?");
        System.out.println();
        System.out.println(player);

        boolean win = false;

        while (!win) {
            
            hauntedhouse.printMapLayout();
            
            Room currentRoom = hauntedhouse.getRoom(playerRow, playerCol);
            
            System.out.println("You are currently at the " + currentRoom.getName());
            pause(3000);
            handleRoomEvents(currentRoom, player, thegame);
            
            if (currentRoom.isMonsterDefeated() && currentRoom.getName().equals("Dark Basement") ) {
                System.out.println("Congratulations, you have won the game");
                System.out.println("You are really tougher than you look");
                win = true;
                break;
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
            return new Weapons(w.getName(), w.getDescription(), w.getRarity(), w.getDamage(), w.getType(), w.getUsesRemaining());
        } else if (original instanceof Consumables) {
            Consumables c = (Consumables) original;
            return new Consumables(c.getName(), c.getDescription(), c.getRarity(), c.getSanityIncrease(), c.getHealthIncrease(), c.getjustformystery1(), c.getjustformystery2());
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
            pause(2000);
            System.out.println("Wait, is that " + monster.getName() + "!");
            pause(5000);
    
            boolean playerAlive = true;
            boolean monsterAlive = true;
    
            while (monster.getHealth() > 0 && player.getHealth() > 0) {
    
                // Monster attacks first
                System.out.println("\n" + monster.getName() + "'s turn!");
                pause(2000);
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

                if (player instanceof Skeptic) {
                    if (monster.getSanitydealer() > 0){
                        pause(1000);
                        System.out.println("You resist their insanity and take "+monster.getSanitydealer()/2);
                        player.setSanity(player.getSanity() - monster.getSanitydealer()/2);

                    }
                    else {
                        player.setSanity(player.getSanity() - monster.getSanitydealer());
                    }
                }
                else {
                    player.setSanity(player.getSanity()-monster.getSanitydealer());
                }
                
                pause(1000);
                System.out.println("Your health: " + player.getHealth());
                System.out.println("Your sanity: " + player.getSanity());
    
                if (player.getHealth() <= 0) {
                    System.out.println("You have been defeated... The house claims another soul.");
                    playerAlive = false;
                    break;
                }
    
                // Player's turn
                boolean validAction = false;
    
                while (!validAction) {
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
                            
                            int originalDamage = weapon.getDamage();
                            int newDamage = weapon.getDamage();

                            // Bonus if it's a Ghost Hunter Gun used against a Ghost
                            if (weapon.getName().toLowerCase().contains("ghost hunter gun") && monster instanceof Ghost && player instanceof Ghosthunter) {
                                newDamage += 50; // You can tweak this bonus value
                                
                                System.out.println("The Ghost Hunter Gun glows brightly! Being a ghost hunter does double damage!");
                            }
                            else if (weapon.getName().toLowerCase().contains("ghost hunter gun") && monster instanceof Ghost) {
                                newDamage += 25;
                                System.out.println("The Ghost Hunter Gun glows brightly!");
                            }

                            
                            if (weapon.getName().toLowerCase().contains("standard knife") && monster instanceof Ghost) {
                                newDamage = 0; // You can tweak this bonus value
                                System.out.println("Your knife is ineffective against this ghost.");
                            }
                            weapon.setDamage(newDamage);
                            weapon.useWeapon();
                            pause(1000);
                            monster.takeDamage(newDamage);
                            weapon.setDamage(originalDamage);
                            if (weapon.getUsesRemaining() == 0){
                                player.removeItemFromInventory(weapon);
                            }

                            validAction = true;
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
                            player.setHealth(player.getHealth()+((Consumables) itemToUse).getHealthIncrease());
                            player.setSanity(player.getSanity()+((Consumables) itemToUse).getSanityIncrease());
                            System.out.println(player);
                            player.removeItemFromInventory(itemToUse);
                            validAction = true;
                        } else {
                            System.out.println("That's not a usable consumable.");
                        }
    
                    } else if (action.equals("3")) {
                        System.out.println("You throw a punch!");
                        int punchDamage = 5;

                        if (!(monster instanceof Ghost)){
                            System.out.println("You deal " + punchDamage + " damage with your fists.");

                            monster.takeDamage(punchDamage);
                        }
                        else {
                            if (player instanceof Ghosthunter){
                                ((Ghost)monster).setDetectible(true);
                                System.out.println("You deal " + punchDamage + " damage with your fists.");

                                monster.takeDamage(punchDamage);
                            }
                            else {
                                System.out.println("The ghost dodged your attack");
                            }
                            
                        }
                        
                        
                        validAction = true;
                    } else {
                        System.out.println("Invalid action. Try again.");
                    }
                }
    
                if (monster.getHealth() <= 0) {
                    System.out.println(monster.getName() + " has been defeated!");
                    monsterAlive = false;
                    if (player instanceof Healer) {
                        ((Healer)player).heal();
                    }
                    break;
                }
            }
    
            if (playerAlive && !monsterAlive) {
                room.setMonsterDefeated();
                System.out.println("\nYou found some items in the room: " + room.displayInventory());
                
                for (int i = 0; i < room.getInventory().size(); i++) {
                    Inventory original = room.getSpecificInventory(i);
                    Inventory copy = copyInventoryItem(original);
                    player.addItemToInventory(copy);
                }
                room.clearInventory();
                System.out.println();
                System.out.println(player);
            }
        }
    }
    
}


