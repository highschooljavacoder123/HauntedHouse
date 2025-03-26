import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("Pick a role to play: Ghost Hunter, Psychic, Skeptic, or Healer");
        Scanner roleinput = new Scanner(System.in);
        
        User bob = new User("bob", 3.0, 5, 5, 5);
        bob.addItemToInventory("tool");
        bob.addItemToInventory("axe");
        bob.addItemToInventory("drink");
        bob.addItemToInventory("food");
        System.out.println(bob.toString());

    
    }
}