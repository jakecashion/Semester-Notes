// Name:        Jake Cashion
// Class:       CS 3305/01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    3
// IDE Name:    Visual Studio Code

import java.util.Scanner;

public class myTest_No_HT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the linked list object
        LinkedList_No_HT myList = new LinkedList_No_HT();

        // Loop to display the menu until user exits
        while (true) {
            System.out.println("\n---------MAIN MENU--------");
            System.out.println("1 - Add First Node");
            System.out.println("2 - Add Last Node");
            System.out.println("3 - Add At Index");
            System.out.println("4 - Remove First Node");
            System.out.println("5 - Remove Last Node");
            System.out.println("6 - Remove At Index");
            System.out.println("7 - Print List Size");
            System.out.println("8 - Print List Forward");
            System.out.println("9 - Print List In Reverse");
            System.out.println("10- Exit program");
            System.out.print("Enter option number: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println(); // Formatting line

            switch (option) {

                // Add First Node
                case 1:
                    System.out.print("Enter value to add: ");
                    int val1 = scanner.nextInt();

                    System.out.println("Adding value " + val1 + " as first node.");
                    System.out.println("List content before adding " + val1 + " is:");
                    myList.printList();
                    System.out.println();

                    myList.addFirstNode(val1);

                    System.out.println("List content after adding " + val1 + " is:");
                    myList.printList();
                    System.out.println();
                    break;

                // Add Last Node
                case 2:
                    System.out.print("Enter value to add: ");
                    int val2 = scanner.nextInt();

                    System.out.println("Adding value " + val2 + " as last node.");
                    System.out.println("List content before adding " + val2 + " is:");
                    myList.printList();
                    System.out.println();

                    myList.addLastNode(val2);

                    System.out.println("List content after adding " + val2 + " is:");
                    myList.printList();
                    System.out.println();
                    break;

                // Add At Index
                case 3:
                    System.out.print("Enter index: ");
                    int idx3 = scanner.nextInt();
                    System.out.print("Enter value to add: ");
                    int val3 = scanner.nextInt();

                    System.out.println("Adding value " + val3 + " at index " + idx3 + ".");
                    System.out.println("List content before adding " + val3 + " is:");
                    myList.printList();
                    System.out.println();

                    myList.addAtIndex(idx3, val3);

                    System.out.println("List content after adding " + val3 + " is:");
                    myList.printList();
                    System.out.println();
                    break;

                // Remove First Node
                case 4:
                    System.out.println("Method removeFirstNode()");
                    System.out.println("List content before removing first node is:");
                    myList.printList();
                    System.out.println();

                    myList.removeFirstNode();

                    System.out.println("List content after removing first node is:");
                    myList.printList();
                    System.out.println();
                    break;

                // Remove Last Node
                case 5:
                    System.out.println("Method removeLastNode()");
                    System.out.println("List content before removing last node is:");
                    myList.printList();
                    System.out.println();

                    myList.removeLastNode();

                    System.out.println("List content after removing last node is:");
                    myList.printList();
                    System.out.println();
                    break;

                // Remove At Index
                case 6:
                    System.out.print("Enter index to remove: ");
                    int idx6 = scanner.nextInt();

                    System.out.println("Method removeAtIndex(" + idx6 + ")");
                    System.out.println("List content before removing node at index " + idx6 + " is:");
                    myList.printList();
                    System.out.println();

                    myList.removeAtIndex(idx6);

                    System.out.println("List content after removing node at index " + idx6 + " is:");
                    myList.printList();
                    System.out.println();
                    break;

                // Print List Size
                case 7:
                    System.out.println("List Size: " + myList.countNodes());
                    break;

                // Print List Forward
                case 8:
                    System.out.print("List content forward: ");
                    myList.printList();
                    System.out.println();
                    break;

                // Print List In Reverse
                case 9:
                    if (myList.countNodes() == 0) {
                        System.out.println("List is Empty");
                    } else {
                        System.out.print("List content reverse: ");
                        // Assuming 'ListName' is the head node field in your class
                        myList.printInReverseRecursive(myList.ListName);
                        System.out.println();
                    }
                    break;

                // Exit program
                case 10:
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
