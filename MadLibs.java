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


        // declares the two variables to check the index of the brackets
        int openBracket; 
        int closedBracket;
        
        //finds the index of both the first closed and opened bracket
        openBracket = template.indexOf("<");
        closedBracket = template.indexOf(">");

        //takes the text in between the brackets and asks for the user to input that type of word
        System.out.print("Give me a " + template.substring(openBracket+1, closedBracket) + ": ");
        //takes the users input
        String userInput = input.nextLine();
        //appends everything from the begining of the template to the open bracket and adds user input
        String finalMadLib = template.substring(0,openBracket) + userInput;


        template = template.substring(closedBracket+1);//sets template to everything after first brackets

        
        openBracket = template.indexOf("<");
        closedBracket = template.indexOf(">");
        System.out.print("Give me a " + template.substring(openBracket+1, closedBracket) + ": ");
        userInput = input.nextLine();
        finalMadLib += template.substring(0, openBracket) + userInput;

        template = template.substring(closedBracket+1);

        
        openBracket = template.indexOf("<");
        closedBracket = template.indexOf(">");
        System.out.print("Give me a " + template.substring(openBracket+1, closedBracket) + ": ");
        userInput = input.nextLine();
        finalMadLib += template.substring(0,openBracket) + userInput;

        template = template.substring(closedBracket+1);

        finalMadLib += template;//adds the rest of the template onto the final Mad Lib

        System.out.println(finalMadLib);//prints the full Mad Lib
        input.close();//closes the scanner
    }
}