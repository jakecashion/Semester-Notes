// Name:        Jake Cashion
// Class:       CS 3305/01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    2
// IDE Name:    Visual Studio Code

import java.util.Scanner;

public class AverageGrades {
    // this method finds average grades
    public static double findAverage(int[] array, int index) {
        // Base case: if we reached the end of the array, return 0
        if (index == array.length) {
            return 0;
        }

        // Recursive step: sum = current element + sum of the rest
        double sum = array[index] + findAverage(array, index + 1);

        // If we are at the start (index 0), divide sum by length to get average
        if (index == 0) {
            return sum / array.length;
        }

        // Otherwise, return the sum
        return sum;
    }

    // Main method - shows the menu so the user can enter the class size,
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] classSize = null; // Array to hold grades

        // Loop to display the menu until user exits
        while (true) {
            System.out.println("\n---------MAIN MENU---------");
            System.out.println("1. Read class size");
            System.out.println("2. Read class grades");
            System.out.println("3. Compute class average");
            System.out.println("4. Exit program");
            System.out.print("\nEnter option number: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {

                // Read class size
                case 1:
                    System.out.print("\nEnter class size: ");
                    int numStudents = scanner.nextInt();
                    // class size cant be negative or zero, keep asking until its valid
                    while (numStudents <= 0) {
                        System.out.print("Class size can't be negative or zero, enter again: ");
                        numStudents = scanner.nextInt();
                    }
                    classSize = new int[numStudents];
                    scanner.nextLine();
                    break;

                // Read class grades
                case 2:
                    if (classSize == null) {
                        System.out.println("\nPlease enter class size first.");
                    } else {
                        System.out.println("\nEnter student grades: ");
                        int count = 0;
                        // Loop to read grades into the array
                        while (count < classSize.length) {
                            System.out.print("Grade " + (count + 1) + ": ");
                            int grade = scanner.nextInt();
                            // grades have to be between 0 and 100, so dont save it
                            // and dont move to the next grade if its not valid
                            if (grade < 0 || grade > 100) {
                                System.out.println("That's not a valid grade, it has to be between 0 and 100.");
                            } else {
                                classSize[count] = grade;
                                count++;
                            }
                        }
                    }
                    break;

                // Compute class average
                case 3:
                    if (classSize == null) {
                        System.out.println("\nPlease enter class size and grades first.");
                    } else {
                        System.out.println(); // Formatting spacing

                        // Print class size
                        System.out.printf("%-25s %d%n", "You entered class size:", classSize.length);

                        // Print all grades on one line
                        System.out.printf("%-25s ", "You entered grades:");
                        for (int i = 0; i < classSize.length; i++) {
                            System.out.print(classSize[i] + " ");
                        }
                        System.out.println(); // New line

                        // Print the average
                        System.out.printf("%-25s %.2f%n", "Class average:", findAverage(classSize, 0));
                    }
                    break;

                // Exit program
                case 4:
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
