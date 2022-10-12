/*
 * Title: Mad Libs Project
 * 
 * Authors: Isaac and Jason
 * Date: 25 September 2022
 * Course: APCSA, Period 4
 * 
 * Description: Collects the user input and generates a story based on it
 */

// imported the Scanner class to get inputs
import java.util.Scanner;

// class definition header
public class MadLibs {

    // methods and variables for the templates
    static class Storage {
        static String template;
        static String template1 = "Bob <last name> is from <place> and is <number> years old.";
        static String template2 = "I <verb (past-tense)> with my <object> to help my <relationship>.";
        static String template3 = "My very <adjective> cat named <name> likes <food>, and eats it every day.";

        // chooses the template based on user input
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

        // counts how many variables are in the template chosen
        static int amountOfVariables(String template) {
            int lenAll = template.length();
            int len = template.replace("<", "").length();
            return lenAll - len;
        }
    }

    // main method
    public static void main(String[] args) {

        // declares and initiates some variables
        Scanner input = new Scanner(System.in);
        String variable;
        String userInput;
        String finalMadLibs = "";
        String template;
        String deletePart;

        // 3 templates to use and choose from
        System.out.print("\nType a number from 1-3 for a Mad Libs version: ");
        int version = 0;
        try {
            version = Integer.parseInt(input.nextLine());
        } catch (Exception exception) {
            System.out.println("\nMust be an integer from 1-3!\n");
            System.exit(0);
        }
        
        System.out.println();
        template = Storage.version(version);
        int numberOfVariables = Storage.amountOfVariables(template);

        // declares the two variables to be used to check the index of < and >
        int openBracket; 
        int closedBracket;

        // loops however many variables there are to replace each part of speech
        for (int i=0; i<numberOfVariables; i++) {
            openBracket = template.indexOf("<");                                    // finds the index of both the first < and > in template
            closedBracket = template.indexOf(">");
            variable = template.substring(openBracket + 1, closedBracket);              // finds the part of speech between < and >
            System.out.print("Give me a " + variable + ": ");                           // asks for the user to input that part of speech
            userInput = input.nextLine();
            finalMadLibs += template.substring(0, openBracket) + userInput; // appends everything from the beginning of template to one before < for the final Mad Libs and adds the user input
            deletePart = template.substring(0, closedBracket + 1);          // deletes the beginning of the template to > by replacing it with nothing
            template = template.replace(deletePart, "");
        }

        // adds the rest of the template onto the final Mad Lib
        finalMadLibs += template;

        // prints the full Mad Lib
        System.out.println("\n" + finalMadLibs + "\n");

        // closes the scanner
        input.close();
    }
}