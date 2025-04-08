import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        
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
            }

            else if (roleinput.toLowerCase().contains("ghosthunter") || roleinput.toLowerCase().contains("ghost hunter")) {
                player = new Ghosthunter(name, 300, 100, 0, 0, 10);
                
                advance = true;
            }

            else if (roleinput.toLowerCase().contains("healer")) {
                player = new Healer(name, 200, 100, 5, 5, 5);
                
                advance = true;
            }
            else if (roleinput.toLowerCase().contains("skeptic")){
                player = new Skeptic(name, 250, 100, 5, 5, 5);
                
                advance = true;
            }
            else {
                System.out.println("Invalid role");
                advance = false;
            }

        }

        HauntedHouse hauntedhouse = new HauntedHouse();

        System.out.println("Hello there " + player.getName() + ". You might be a "+player.getRole()+" but have you got the guts to survive?");
        System.out.println();


        boolean loss = false;
        
        while (!loss) {
            hauntedhouse.printMapLayout();
            System.out.println("You are currently at the "+ hauntedhouse.getRoom(playerRow, playerCol).getName());

            System.out.println("Suddenly, a monster appears! It looks odd, what is that?");
            try {
                Thread.sleep(4000); 
            } 
            catch (InterruptedException e) {
                e.printStackTrace(); 
            }

            hauntedhouse.getRoom(playerRow,playerCol).getMonsters().attack();

            
            boolean first = true;
            while (first) {
                System.out.println("Do you want to search the room for tools? \n1: Yes \n2: No");
                Integer interaction = thegame.nextInt();
                if (interaction == 1) {
                    System.out.println("You found some items in the room:"+ hauntedhouse.getRoom(playerRow,playerCol).displayInventory());
                    
                    
                    boolean second = true;
                    while (second) {
                        System.out.println("Do you want to pick any of these items up? \n1: Yes \n2: No");
                        Integer pickup1 = thegame.nextInt();
                        if  (pickup1 == 1) {
                            second = false;
                        }
                        else if (pickup1 == 2){
                            second = false;

                        }
                        else {
                            System.out.println("Invalid input");
                        }
                    }



                    first = false;
                }
                else if (interaction == 2) {
                    first = false;
                }
                else {
                    System.out.println("Invalid input");
                }
            }

            

            



            loss = true;
        }
        


        thegame.close();



    
        

    
    }
}