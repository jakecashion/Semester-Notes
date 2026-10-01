// Name:        Jake Cashion
// Class:       CS 3305/01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    4
// IDE Name:    Visual Studio Code

// This class defines a generic stack (type E) using a linked list.

public class MyStack<E>
{
   private Node top;  // reference to the node on top of the stack
   private int size;  // number of elements currently in the stack

   // creates an empty stack
   public MyStack()
   {
      top = null;
      size = 0;
   }

   // adds a new element to the top of the stack
   public void push(E element)
   {
      Node newNode = new Node(element);
      newNode.next = top; // new node points to the old top
      top = newNode;      // new node becomes the top
      size++;
   }

   // removes and returns the element on top of the stack
   // returns null if the stack is empty
   public E pop()
   {
      if (isEmpty()) {
         return null;
      }

      E element = top.data; // save the data before unlinking the node
      top = top.next;       // move top down to the next node
      size--;
      return element;
   }

   // returns the element on top of the stack without removing it
   // returns null if the stack is empty
   public E top()
   {
      if (isEmpty()) {
         return null;
      }

      return top.data;
   }

   // returns how many elements are currently in the stack
   public int size()
   {
      return size;
   }

   // returns true if the stack has no elements, false otherwise
   public boolean isEmpty()
   {
      return top == null;
   }

   // prints the stack from the top element to the bottom element
   // prints "Empty Stack" if there is nothing to print
   public void printStack()
   {
      if (isEmpty()) {
         System.out.print("Empty Stack");
         return;
      }

      Node temp = top;
      // walk down the list from the top node to the last node
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }

   // class to create nodes as objects
   private class Node
   {
      private E data;    //data field
      private Node next; //link field

      public Node(E item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}
