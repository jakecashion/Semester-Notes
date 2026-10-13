// Name:        Jake Cashion
// Class:       CS 3305/01
// Term:        Fall 2026
// Instructor:    Maxwell Bradley
// Assignment:    5
// IDE Name:    Visual Studio Code

// This class defines a generic queue (type E) using a linked list.
// Elements are added at the back of the queue and removed from the front.

public class Queue<E>
{
   private Node head; // reference to the node at the front of the queue
   private int size;  // number of elements currently in the queue

   // creates an empty queue
   public Queue()
   {
      head = null;
      size = 0;
   }

   // adds a new element to the back of the queue
   public void enqueue(E element)
   {
      Node newNode = new Node(element);

      if (head == null)
         head = newNode; //one node queue
      else
      {
         Node temp = head;
         // walk down the list until the last node is reached
         while (temp.next != null)
         {
            temp = temp.next;
         }

         temp.next = newNode; //link new node as last node
      }
      size++;
   }

   // removes and returns the element at the front of the queue
   // returns null if the queue is empty
   public E dequeue()
   {
      if (isEmpty()) {
         return null;
      }

      E element = head.data; // save the data before unlinking the node
      head = head.next;      // move head to the next node
      size--;
      return element;
   }

   // returns the element at the front of the queue without removing it
   // returns null if the queue is empty
   public E front()
   {
      if (isEmpty()) {
         return null;
      }

      return head.data;
   }

   // returns how many elements are currently in the queue
   public int size()
   {
      return size;
   }

   // returns true if the queue has no elements, false otherwise
   public boolean isEmpty()
   {
      return head == null;
   }

   // prints the queue from the front element to the back element
   // prints "Empty Queue" if there is nothing to print
   public void printQueue()
   {
      if (isEmpty()) {
         System.out.print("Empty Queue");
         return;
      }

      Node temp = head;
      // walk down the list from the front node to the last node
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
