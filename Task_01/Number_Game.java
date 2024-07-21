package Task_01;

import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class Number_Game {

    public static void main(String[] args) throws IOException {
        System.out.println("\t\tWELLCOME TO NUMBER GUESS GAME\n");
        System.out.println("\tTHIS GAME GENERATE RANDOM NUMBER BETWEEN [1-100]");
        System.out.println("\t   GUESS THE RIGHT NUMBER & WIN THE POINTS");
        System.out.println("\tYOU HAVE ONLY FIVE(5) ATTEMPTS TO WIN THE GAME");
        System.out.println("\t\t10 FOR CORRECT -1 FOR INCORRECT");
        System.out.print("\nEnter Player Name---");
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        Game obj = new Game(str);
        
        System.out.println(str + " Enter 1 for start");
        int num1 = sc.nextInt();
        
        if (num1 == 1) {
            obj.numberGuess(sc);
        } else {
            System.out.println("\n\t......GAME EXIT........");
            System.exit(0);
        }
        
        while (true) {
            System.out.println(" 1 For Play Again");
            System.out.println(" 0 For Exit");
            
            int num2 = sc.nextInt();
                
            if (num2 == 1) {
                obj.numberGuess(sc);
            } else {
                System.out.println("\n\t......GAME EXIT........");
                System.exit(0);
            }
        }
    }    
}

class Game {
    
    String str;
    
    Game(String str) {  
        this.str = str;  
    }
    
    void numberGuess(Scanner sc) {
        int i = 0;
        Random random = new Random();
        int count = 10;
        int ranNum = random.nextInt(101); 
        
        while (i < 5) {
            System.out.println("\n\tGuess the Number");
            int guessNum = sc.nextInt();
            if (guessNum == ranNum) {
                System.out.println("Correct " + this.str + " You Win Points---> " + (count - i));
                System.out.println("No.Of Attempts Completed---> " + (i + 1));
                break;
            } else if (guessNum < ranNum) {
                System.out.println("\nToo Low....Try Again");
            } else {
                System.out.println("\nToo High...Try Again"); 
            }
            i++;     
        }
        if (i == 5) {
            System.out.println("\n\t......GAME OVER........\n");
        }
    }    
}
