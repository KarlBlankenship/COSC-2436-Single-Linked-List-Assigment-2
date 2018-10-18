/*
 * Create two methods, inser and delete, that allows
 * a new node to be inserted or deleted from any location 
 * in the linked list.
 */
package SingleLinkedList.Assignment2;

/**
 * The SingleLinkedList class will contain a private internal
 * class for defining a single linked node. There will be methods
 * for manipulating the list as well as a main method for creating
 * a list and testing the methods.
 * @author Karl
 */
public class SingleLinkedList 
{

    private class Node
    {
        String value;   // Reference variable holding node contents.
        Node next;      // Reference variable for holding the next node.
        
        /**
         * Constructor accepting the node value.
         * @param val The value to be kept in the node.
         */
        Node(String val)
        {
            this.value = val;
        }
    }
    
    // Create variable to hold the head and the tail of the list.
    Node head;      // First element in the list.
    Node tail;      // Last element in the list.
    
    /**
     * The push method will create a new node and will push the
     * node into the front of the list.
     * @param val The value to be contained in the new node.
     */
    private void push(String val)
    {
        // Create a new node.
        Node n = new Node(val);
        
        // If the list is empty, set the new node to the head and the tail.
        if (head == null)
        {
            head = n;   // No existing elements so new node becomes the head.
            tail = n;   // No existing elements so new node becomes the tail.
        }
        // Else, there are already elements so add to the beginning.
        else
        {
            n.next = head;  // Set the new node as the first node in the list.
            head = n;       // Reassign the head reference to the new node.
        }    
    }
    
    /**
     * The add method is used for adding a new node to the end
     * of a single linked list.
     * @param val The value to be contained in the new node.
     */
    private void add(String val)
    {
        // Create the new node.
        Node n = new Node(val);
        
        // If the list is empty, set the new node to the head and the tail.
        if (head == null)
        {
            head = n;   // No existing elements so new node becomes the head.
            tail = n;   // No existing elements so new node becomes the tail.
        }
        // Else, there are already elements so add to the end.
        else
        {
            tail.next = n;  // Set the current tail to point to the new node.
            tail = n;       // Reassign the tail reference variable to n.
        }    
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
