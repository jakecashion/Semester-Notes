// Name:        Jake Cashion
// Class:       CS 3305/01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    4
// IDE Name:    Visual Studio Code

import java.util.Scanner;

public class CheckPalindrome {

    // This method checks whether a string is a palindrome using a stack
    // Spaces, punctuation and letter case are ignored
    public static boolean isPalindrome(String str) {
        // Create the stack that holds one character per element
        MyStack<Character> charStack = new MyStack<Character>();
        String cleaned = "";

        // Keep only letters and digits, in lowercase
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                cleaned += Character.toLowerCase(c);
            }
        }

        // Push every character onto the stack
        for (int i = 0; i < cleaned.length(); i++) {
            charStack.push(cleaned.charAt(i));
        }

        // Pop the characters off (this gives the string in reverse order)
        // and compare each one to the original string from the front
        for (int i = 0; i < cleaned.length(); i++) {
            char fromStack = charStack.pop();
            if (fromStack != cleaned.charAt(i)) {
                return false; // mismatch found, not a palindrome
            }
        }

        return true; // every character matched
    }

    // Main method - shows the menu and lets the user enter a string and check it
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = "";

        // Loop to display the menu until user exits
        while (true) {
            System.out.println("\n");
            System.out.println("-----------------MAIN MENU----------------");
            System.out.println("1 - Read input string");
            System.out.println("2 - Check palindrome and display output");
            System.out.println("3 - Exit program");
            System.out.print("Enter option number: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("\n"); // Formatting lines

            switch (option) {
                // Read input string
                case 1:
                    System.out.print("Please enter a string: ");
                    inputString = scanner.nextLine();
                    break;

                // Check palindrome and display output
                case 2:
                    System.out.println("Entered String:\t" + inputString);
                    if (isPalindrome(inputString)) {
                        System.out.println("Judgment:\tPalindrome");
                    } else {
                        System.out.println("Judgment:\tNot Palindrome");
                    }
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
