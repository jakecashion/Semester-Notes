// Name:        Jake Cashion
// Class:       CS 3305/01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    4
// IDE Name:    Visual Studio Code

import java.util.Scanner;

public class TestMyStack {

    // Main method - shows the menu and lets the user test every stack method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the integer stack object
        MyStack<Integer> myStack = new MyStack<Integer>();

        // Loop to display the menu until user exits
        while (true) {
            System.out.println("\n");
            System.out.println("--------MAIN MENU-------");
            System.out.println("1 - Push element");
            System.out.println("2 - Pop element");
            System.out.println("3 - Get top element");
            System.out.println("4 - Get stack size");
            System.out.println("5 - Is empty stack?");
            System.out.println("6 - Print stack");
            System.out.println("7 - Exit program");
            System.out.print("Enter option number: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("\n"); // Formatting lines

            switch (option) {

                // Push element
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = scanner.nextInt();

                    System.out.println("Method push(" + val + ")");
                    System.out.print("Stack content before push (top to bottom): ");
                    myStack.printStack();
                    System.out.println();

                    myStack.push(val);

                    System.out.print("Stack content after push (top to bottom): ");
                    myStack.printStack();
                    System.out.println();
                    break;

                // Pop element
                case 2:
                    System.out.println("Method pop()");
                    System.out.print("Stack content before pop (top to bottom): ");
                    myStack.printStack();
                    System.out.println();

                    if (myStack.isEmpty()) {
                        System.out.println("Cannot pop, stack is empty");
                    } else {
                        System.out.println("Popped element: " + myStack.pop());
                    }

                    System.out.print("Stack content after pop (top to bottom): ");
                    myStack.printStack();
                    System.out.println();
                    break;

                // Get top element
                case 3:
                    System.out.println("Method top()");
                    System.out.print("Stack content before top (top to bottom): ");
                    myStack.printStack();
                    System.out.println();

                    if (myStack.isEmpty()) {
                        System.out.println("Cannot get top element, stack is empty");
                    } else {
                        System.out.println("Top element: " + myStack.top());
                    }

                    System.out.print("Stack content after top (top to bottom): ");
                    myStack.printStack();
                    System.out.println();
                    break;

                // Get stack size
                case 4:
                    System.out.print("Stack content (top to bottom): ");
                    myStack.printStack();
                    System.out.println();
                    System.out.println("Stack size: " + myStack.size());
                    break;

                // Is empty stack?
                case 5:
                    System.out.print("Stack content (top to bottom): ");
                    myStack.printStack();
                    System.out.println();
                    if (myStack.isEmpty()) {
                        System.out.println("Is stack empty? Yes");
                    } else {
                        System.out.println("Is stack empty? No");
                    }
                    break;

                // Print stack
                case 6:
                    System.out.print("Stack content (top to bottom): ");
                    myStack.printStack();
                    System.out.println();
                    break;

                // Exit program
                case 7:
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
