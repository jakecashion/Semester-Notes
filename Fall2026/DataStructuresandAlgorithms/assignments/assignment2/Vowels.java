// Name:        Jake Cashion
// Class:       CS 3305/01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    2
// IDE Name:    Visual Studio Code

import java.util.Scanner;

public class Vowels {
    // This method counts how many vowels are in a string
    public static int countVowels(String str) {
        // Base case: if the string is empty, return 0
        if (str.isEmpty()) {
            return 0;
        }

        // Get the first character and convert to lowercase
        char firstChar = str.toLowerCase().charAt(0);
        int count = 0;

        // Check if the character is a vowel
        if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') {
            count = 1;
        }

        // Recursive call with the rest of the string
        String smallerstr = str.substring(1);
        return count + countVowels(smallerstr);
    }

    // Main method - shows the menu and lets the user type in a string,
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = "";

        // Loop to display the menu until user exits
        while (true) {
            System.out.println("\n---------MAIN MENU---------");
            System.out.println("1. Read input string");
            System.out.println("2. Compute number of vowels");
            System.out.println("3. Exit program");
            System.out.print("\nEnter option number: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                // Read input string
                case 1:
                    System.out.print("\nPlease enter a string: ");
                    inputString = scanner.nextLine();
                    break;

                // Compute number of vowels
                case 2:
                    System.out.println("\nYou entered string:\t" + inputString);
                    System.out.println("Number of vowels:\t" + countVowels(inputString));
                    break;

                // Exit the program
                case 3:
                    System.out.println("\nExiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                // Handle invalid input
                default:
                    System.out.println("\nInvalid option. Please try again.");
                    break;
            }
        }
    }
}
