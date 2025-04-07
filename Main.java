import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        
        Scanner thegame = new Scanner(System.in);

        System.out.println("Please enter your name");
        String name = thegame.nextLine();

        

        boolean advance = false;
        while (!advance) {
            System.out.println("Pick a role to play: Ghost Hunter, Psychic, Skeptic, or Healer");
            String roleinput = thegame.nextLine();

            if (roleinput.toLowerCase().contains("psychic")) {
                Psychic player = new Psychic(name, 100, 100, 5, 5, 5);
                
                advance = true;
            }

            else if (roleinput.toLowerCase().contains("ghosthunter") || roleinput.toLowerCase().contains("ghost hunter")) {
                Ghosthunter player = new Ghosthunter(name, 100, 100, 0, 0, 10);
                
                advance = true;
            }

            else if (roleinput.toLowerCase().contains("healer")) {
                Healer player = new Healer(name, 100, 100, 5, 5, 5);
                
                advance = true;
            }
            else if (roleinput.toLowerCase().contains("skeptic")){
                Skeptic player = new Skeptic(name, 100, 100, 5, 5, 5);
                
                advance = true;
            }
            else {
                System.out.println("Invalid role");
                advance = false;
            }

        }

        HauntedHouse hauntedhouse = new HauntedHouse();
        hauntedhouse.printMapLayout();


        thegame.close();



    
        

    
    }
}