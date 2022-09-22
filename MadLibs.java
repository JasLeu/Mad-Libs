/*
 * Mad Libs Project
 * Isaac and Jason
 * 21 September 2022
 * Mrs. Woldseth
 * APCSA, Period 4
 * Collects the user input and generates a story based on it
 * 
 * 
 */

// imported the Scanner class to get inputs
import java.util.Scanner;

public class MadLibs {
    public static void main(String[] args) {

        // declares and initiates the variables
        Scanner input = new Scanner(System.in);
        String template1 = "";
        String template2 = "";
        String template3 = "";
        String myTemplate;
        String variable;

        // grabs the user input
        try {
            System.out.println("Type a number from 1-3: ");
            int template = input.nextInt();

            if (template == 1) {
                System.out.print("WIP 1");
            } else if (template == 2) {
                System.out.print("WIP 2");
            } else if (template ==3) {
                System.out.print("WIP 3");
            }
            
        } finally {
            input.close();
        }

    }
}