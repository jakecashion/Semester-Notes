// Name:        Jake Cashion
// Class:       CS 3305/01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    5
// IDE Name:    Visual Studio Code

import java.util.Scanner;

public class TestQueue {

    // Main method - shows the menu and lets the user test every queue method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the integer queue object
        Queue<Integer> myQueue = new Queue<Integer>();

        // Loop to display the menu until user exits
        while (true) {
            System.out.println("\n");
            System.out.println("--------MAIN MENU-------");
            System.out.println("1 - Enqueue element");
            System.out.println("2 - Dequeue element");
            System.out.println("3 - Get front element");
            System.out.println("4 - Get queue size");
            System.out.println("5 - Is empty queue?");
            System.out.println("6 - Print queue");
            System.out.println("7 - Exit program");
            System.out.print("Enter option number: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("\n"); // Formatting lines

            switch (option) {

                // Enqueue element
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int val = scanner.nextInt();

                    System.out.println("Method enqueue(" + val + ")");
                    System.out.print("Queue content before enqueue (front to back): ");
                    myQueue.printQueue();
                    System.out.println();

                    myQueue.enqueue(val);

                    System.out.print("Queue content after enqueue (front to back): ");
                    myQueue.printQueue();
                    System.out.println();
                    break;

                // Dequeue element
                case 2:
                    System.out.println("Method dequeue()");
                    System.out.print("Queue content before dequeue (front to back): ");
                    myQueue.printQueue();
                    System.out.println();

                    if (myQueue.isEmpty()) {
                        System.out.println("Cannot dequeue, Empty Queue");
                    } else {
                        System.out.println("Dequeued element: " + myQueue.dequeue());
                    }

                    System.out.print("Queue content after dequeue (front to back): ");
                    myQueue.printQueue();
                    System.out.println();
                    break;

                // Get front element
                case 3:
                    System.out.println("Method front()");
                    System.out.print("Queue content before front (front to back): ");
                    myQueue.printQueue();
                    System.out.println();

                    if (myQueue.isEmpty()) {
                        System.out.println("Cannot get front element, Empty Queue");
                    } else {
                        System.out.println("Front element: " + myQueue.front());
                    }

                    System.out.print("Queue content after front (front to back): ");
                    myQueue.printQueue();
                    System.out.println();
                    break;

                // Get queue size
                case 4:
                    System.out.print("Queue content (front to back): ");
                    myQueue.printQueue();
                    System.out.println();
                    if (myQueue.isEmpty()) {
                        System.out.println("Empty Queue, queue size: 0");
                    } else {
                        System.out.println("Queue size: " + myQueue.size());
                    }
                    break;

                // Is empty queue?
                case 5:
                    System.out.print("Queue content (front to back): ");
                    myQueue.printQueue();
                    System.out.println();
                    if (myQueue.isEmpty()) {
                        System.out.println("Is queue empty? Yes");
                    } else {
                        System.out.println("Is queue empty? No");
                    }
                    break;

                // Print queue
                case 6:
                    System.out.print("Queue content (front to back): ");
                    myQueue.printQueue();
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
