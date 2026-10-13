// Name:        Jake Cashion
// Class:       CS 3305/01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    5
// IDE Name:    Visual Studio Code

import java.util.Scanner;

public class RadixSort {

    // The ten queues used by radix sort, one for each digit value 0 to 9
    static Queue<Integer> Q0 = new Queue<Integer>();
    static Queue<Integer> Q1 = new Queue<Integer>();
    static Queue<Integer> Q2 = new Queue<Integer>();
    static Queue<Integer> Q3 = new Queue<Integer>();
    static Queue<Integer> Q4 = new Queue<Integer>();
    static Queue<Integer> Q5 = new Queue<Integer>();
    static Queue<Integer> Q6 = new Queue<Integer>();
    static Queue<Integer> Q7 = new Queue<Integer>();
    static Queue<Integer> Q8 = new Queue<Integer>();
    static Queue<Integer> Q9 = new Queue<Integer>();

    // This method returns the queue that matches a digit (0 to 9)
    public static Queue<Integer> getQueue(int digit) {
        switch (digit) {
            case 0: return Q0;
            case 1: return Q1;
            case 2: return Q2;
            case 3: return Q3;
            case 4: return Q4;
            case 5: return Q5;
            case 6: return Q6;
            case 7: return Q7;
            case 8: return Q8;
            default: return Q9;
        }
    }

    // This method counts how many digits are in a number
    // Digits are counted mathematically by dividing by 10 (no strings)
    public static int CountDigits(int number) {
        // 0 still has one digit
        if (number == 0) {
            return 1;
        }

        int count = 0;
        // remove one digit at a time until nothing is left
        while (number > 0) {
            number = number / 10;
            count++;
        }
        return count;
    }

    // This method returns the digit found at a given position of a number
    // position 1 is the ones digit, 2 is the tens digit, 3 is the hundreds digit...
    // Example: ExtractDigit(3465, 3) returns 4
    public static int ExtractDigit(int number, int position) {
        // find 10^(position - 1)
        int divisor = 1;
        for (int i = 1; i < position; i++) {
            divisor = divisor * 10;
        }

        // shift the wanted digit to the ones place, then keep only that digit
        return (number / divisor) % 10;
    }

    // This method sorts the array using radix sort with the ten queues
    public static void radixSort(int[] inputs) {
        // Find the largest value, it decides how many passes are needed
        int max = inputs[0];
        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i] > max) {
                max = inputs[i];
            }
        }
        int maxDigits = CountDigits(max);

        // One pass for each digit position, starting at the ones digit
        for (int position = 1; position <= maxDigits; position++) {

            // Distribute: enqueue each value into the queue of its current digit
            for (int i = 0; i < inputs.length; i++) {
                int digit = ExtractDigit(inputs[i], position);
                getQueue(digit).enqueue(inputs[i]);
            }

            // Collect: dequeue Q0 through Q9 in order back into the array
            int index = 0;
            for (int d = 0; d <= 9; d++) {
                Queue<Integer> current = getQueue(d);
                while (!current.isEmpty()) {
                    inputs[index] = current.dequeue();
                    index++;
                }
            }
        }
    }

    // This method builds a string with the array values separated by commas
    public static String arrayToString(int[] inputs) {
        String result = "";
        for (int i = 0; i < inputs.length; i++) {
            result += inputs[i];
            if (i < inputs.length - 1) {
                result += ", ";
            }
        }
        return result;
    }

    // Main method - shows the menu and lets the user read, sort and print the array
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputs = null;           // the one and only array
        boolean sizeRead = false;      // true once option 1 was done
        boolean valuesRead = false;    // true once option 2 was done

        // Loop to display the menu until user exits
        while (true) {
            System.out.println("\n");
            System.out.println("---------------MAIN MENU--------------");
            System.out.println("1 - Read array size");
            System.out.println("2 - Read array values");
            System.out.println("3 - Run Radix Sort and print outputs");
            System.out.println("4 - Exit program");
            System.out.print("Enter option number: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("\n"); // Formatting lines

            switch (option) {

                // Read array size
                case 1:
                    int size = 0;
                    // keep asking until the size is a positive number
                    while (size <= 0) {
                        System.out.print("Enter number of input values (array size): ");
                        size = scanner.nextInt();
                        if (size <= 0) {
                            System.out.println("Invalid size, enter a number greater than 0");
                        }
                    }
                    inputs = new int[size];
                    sizeRead = true;
                    valuesRead = false; // old values no longer match the new array
                    System.out.println("Array size set to " + size);
                    break;

                // Read array values
                case 2:
                    if (!sizeRead) {
                        System.out.println("Array size not entered yet, choose option 1 first");
                        break;
                    }
                    for (int i = 0; i < inputs.length; i++) {
                        int value = -1;
                        // reject negative values and ask again
                        while (value < 0) {
                            System.out.print("Enter positive integer value " + (i + 1) + ": ");
                            value = scanner.nextInt();
                            if (value < 0) {
                                System.out.println("Negative values are not allowed, try again");
                            }
                        }
                        inputs[i] = value;
                    }
                    valuesRead = true;
                    break;

                // Run Radix Sort and print outputs
                case 3:
                    if (!valuesRead) {
                        System.out.println("Array values not entered yet, choose options 1 and 2 first");
                        break;
                    }
                    // Save the unsorted array as a string before it gets changed
                    String before = arrayToString(inputs);

                    radixSort(inputs);

                    System.out.println("Array values before sorting:    " + before);
                    System.out.println("Array values after sorting:     " + arrayToString(inputs));
                    break;

                // Exit program
                case 4:
                    System.out.println("Exiting program...");
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
