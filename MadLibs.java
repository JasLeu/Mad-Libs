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

        
        String template = "Bob <last name> is from <place> and is <number> years old.";


        // String template = "I <verb> with my <object> to help my <relationship>";


        // String template = "My very <adjective> cat named <name> likes <food>, and eats it every day.";


        
        int openBracket = template.indexOf("<");
        int closedBracket = template.indexOf(">");
        System.out.print("Give me a " + template.substring(openBracket+1, closedBracket) + ": ");
        String userInput = input.next();
        String finalMadLib = template.substring(0,openBracket) + userInput;

        openBracket = template.indexOf("<");
        closedBracket = template.indexOf(">");
        System.out.print("Give me a " + template.substring(openBracket+1, closedBracket) + ": ");
        userInput = input.next();
        finalMadLib = template.substring(0,openBracket) + userInput;

    }
}