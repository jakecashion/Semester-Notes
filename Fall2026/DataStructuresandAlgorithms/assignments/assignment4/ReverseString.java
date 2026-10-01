// Name:        Jake Cashion
// Class:       CS 3305/01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    4
// IDE Name:    Visual Studio Code

import java.util.Scanner;

public class ReverseString {

    // This method reverses the order of the words in a sentence using a stack
    public static String reverseWords(String sentence) {
        // Create the stack that holds one word per element
        MyStack<String> wordStack = new MyStack<String>();

        // Split the sentence on spaces and push each word onto the stack
        String[] words = sentence.trim().split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                wordStack.push(word);
            }
        }

        // Pop every word off the stack, the last word pushed comes out first
        String reversed = "";
        while (!wordStack.isEmpty()) {
            reversed += wordStack.pop();
            // add a space between words, but not after the last one
            if (!wordStack.isEmpty()) {
                reversed += " ";
            }
        }

        return reversed;
    }

    // Main method - shows the menu and lets the user enter and reverse a sentence
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = "";

        // Loop to display the menu until user exits
        while (true) {
            System.out.println("\n");
            System.out.println("-----------------MAIN MENU---------------");
            System.out.println("1 - Read input string of words");
            System.out.println("2 - Reverse string and display outputs");
            System.out.println("3 - Exit program");
            System.out.print("Enter option number: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("\n"); // Formatting lines

            switch (option) {
                // Read input string
                case 1:
                    System.out.print("Please enter a string of words: ");
                    inputString = scanner.nextLine();
                    break;

                // Reverse string and display outputs
                case 2:
                    System.out.println("Entered string:\t" + inputString);
                    System.out.println("Reversed String:\t" + reverseWords(inputString));
                    break;

                // Exit the program
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                // Handle invalid input
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
