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

        class Storage {
            static String template;
            static String template1 = "Bob <last name> is from <place> and is <number> years old.";
            static String template2 = "I <verb> with my <object> to help my <relationship>.";
            static String template3 = "My very <adjective> cat named <name> likes <food>, and eats it every day.";

            static String version(int number) {
                if (number == 1) {
                    template = template1;
                } else if (number == 2) {
                    template = template2;
                } else if (number == 3) {
                    template = template3;
                } else {
                    System.exit(1);
                }
                return template;
            }
        }

        // declares and initiates the variables
        Scanner input = new Scanner(System.in);
        String variable;
        String userInput;
        String finalMadLibs = "";
        String template;

        // 3 templates to use and choose from
        System.out.print("Type a number from 1-3 for a Mad Libs version: ");
        int version = input.nextInt();
        System.out.println();
        template = Storage.version(version);

        // declares the two variables to be used to check the index of < and >
        int openBracket; 
        int closedBracket;
        
        // block of code {
            // finds the index of both the first < and the first > in the template
            openBracket = template.indexOf("<");
            closedBracket = template.indexOf(">");

            // finds the part of speech between < and >
            variable = template.substring(openBracket + 1, closedBracket);
            
            // asks for the user to input that part of speech
            System.out.print("Give me a " + variable + ": ");

            // takes the users input
            userInput = input.next();

            // appends everything from the beginning of the template to the open bracket for the final mad lib and adds user input
            finalMadLibs += template.substring(0, openBracket) + userInput;

            // sets template to everything after first brackets
            template = template.substring(closedBracket + 1);

        // } code ends
        
        openBracket = template.indexOf("<");
        closedBracket = template.indexOf(">");
        System.out.print("Give me a " + template.substring(openBracket + 1, closedBracket) + ": ");
        userInput = input.next();
        finalMadLibs += template.substring(0, openBracket) + userInput;
        template = template.substring(closedBracket + 1);

        openBracket = template.indexOf("<");
        closedBracket = template.indexOf(">");
        System.out.print("Give me a " + template.substring(openBracket + 1, closedBracket) + ": ");
        userInput = input.next();
        finalMadLibs += template.substring(0, openBracket) + userInput;
        template = template.substring(closedBracket+1);

        // adds the rest of the template onto the final Mad Lib
        finalMadLibs += template;

        // prints the full Mad Lib
        System.out.println("\n" + finalMadLibs + "\n");

        // closes the scanner
        input.close();
    }
}