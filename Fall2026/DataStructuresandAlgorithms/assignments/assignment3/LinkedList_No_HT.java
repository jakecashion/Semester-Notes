// Name:        Jake Cashion
// Class:       CS 3305/01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    3
// IDE Name:    Visual Studio Code

// This class defines a linked list that stores integer values.
// It does not use head and tail pointers like the textbook version does.

public class LinkedList_No_HT
{
   public Node ListName;

   // creates an empty list
   public LinkedList_No_HT()
   {
      ListName = null;
   }

   // adds a node to the end of the list
   public void addLastNode(int data)
   {
      if (ListName == null)
         ListName = new Node(data); //one node list
      else
      {
         Node temp = ListName;
         while (temp.next != null)
         {
            temp = temp.next;
         }

         temp.next = new Node(data); //link new node as last node
      }
   }

   // adds a new node to the very front of the list
   public void addFirstNode(int data)
   {
      if (ListName == null)
         ListName = new Node(data);
      else {
         Node newNode = new Node(data);
         newNode.next = ListName;
         ListName = newNode;
      }
   }

   // adds a new node at a specific index in the list
   public void addAtIndex(int index, int data)
   {  // reject a bad index before doing anything else
      if (index < 0) {
         System.out.println("Invalid index, try again");
         return;
      }
      // Case 0: Add to front
      if (index == 0)
         addFirstNode(data);
      // Case 1: Index is larger than size, add to end
      else if (index >= countNodes()) {
         addLastNode(data);
      // Case 2: Add to middle
      } else {
         Node current = ListName;
         Node temp = ListName.next;
         for (int i=1; i < index; i++) {
            current = current.next;
            temp = temp.next;
         }
         current.next = new Node(data);
         current.next.next = temp;
      }
   }

   // removes the first node in the list
   public void removeFirstNode()
   {
      if (countNodes() == 0) {
         System.out.println("List is Empty");
         return;
      } else {
         // Move pointer to the next node
         ListName = ListName.next;
      }
   }

   // removes the last node in the list
   public void removeLastNode()
   {
      if (countNodes() == 0) {
         System.out.println("List is Empty");
         return;
      // if list is one, the list becomes null
      } else if (countNodes() == 1) {
         ListName = null;
      } else {
         Node current = ListName;
         // Traverse to the second to last node
         while (current.next.next != null) {
            current = current.next;
         }
         // set next to null to remove the last node
         current.next = null;
      }
   }

   // removes the node at a specific index
   public void removeAtIndex(int index) {
      // Validate index
      if (index < 0 || index >= countNodes()) {
          System.out.println("Invalid index, try again");
          return;
      }

      // Case 1: Remove first node
      if (index == 0) {
          removeFirstNode();
      }
      // Case 2: Remove last node
      else if (index == countNodes() - 1) {
          removeLastNode();
      }
      // Case 3: Remove from middle
      else {
          Node current = ListName;
          // Traverse to the node just BEFORE the one we want to remove
          for (int i = 0; i < index - 1; i++) {
              current = current.next;
          }
          // Link previous node to the next-next node, skipping the deleted one
          current.next = current.next.next;
      }
  }

   // counts how many nodes are currently in the list
   public int countNodes()
   {
      int listSize= 0;

      Node temp = ListName;

      while (temp != null) {
         listSize += 1;
         temp = temp.next;
      }

      return listSize;
   }

   // recursively prints the list backwards (from last node to first)
   public void printInReverseRecursive(Node L)
   {
      if (L == null) {
         return;
      }
      // recursive call
      printInReverseRecursive(L.next);

      System.out.print(L.data + "  ");
   }

   // prints out the list from front to back
   public void printList()
   {
      Node temp;
      temp = ListName;
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }

   // class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field

      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}
