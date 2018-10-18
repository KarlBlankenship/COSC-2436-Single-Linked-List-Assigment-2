/*
 * Create two methods, insert and delete, that allows
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
    
    // Create variables to hold the head and the tail of the list.
    Node head;      // First element in the list.
    Node tail;      // Last element in the list.
    
    /**
     * The insert method will search for an element value that 
     * matches the value passed in as after. The argument passed
     * in as val will then be written into a node following after.
     * @param val The new value to be written into the new node.
     * @param after The value in the list after which the new node is placed.
     */
    private void insert(String val, String after)
    {
        // Create  a temporary Node for keeping place in the list.
        Node pointer = head;    // Will cycle through the list.
        
        // Create the new Node.
        Node n = new Node(val);
        
        //Check to see if head matches the 
        if (head.value.equals(after))
        {
            n.next = head.next;
            head.next = n;
        }
        else
        {
            pointer = head.next;    // Move pointer to first element after head.
            while (pointer != null)
            {
                if (pointer.value.equals(after))
                {
                    if (pointer == tail)
                    {
                        pointer.next = n;
                        tail = n;
                    }
                    else
                    {
                        n.next = pointer.next;
                        pointer.next = n;
                    }
                }
                pointer = pointer.next; // Advance the pointer.
            }
        }
    }
        
    /**
     * The delete method will search the list for the node value
     * provided and will delete that node if found.
     * @param val The node value to find.
     */
    private void delete(String val)
    {
        // Create temporary nodes to cycle through the list.
        Node pointer = head;  // The pointer will cycle through list.
        Node previous = head; // After head, the previous will follow pointer.
        
        // Check to see if the value to delete is contained in the head.
        if (head.value.equals(val))
        {
            head = head.next;
        }
        // Else, if the value is in the list, it is past the head.
        else
        {
            pointer = head.next;  // Advance the pointer since head was checked.
            while (pointer != null)
            {
                if (pointer.value.equals(val))
                {
                    previous.next = pointer.next;
                    if (previous.next == null)
                        tail = previous;
                }
                previous = pointer;
                pointer = pointer.next;
            }
        }
    }
    
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
    
    private void display()
    {
        // Create a temporary node to use as a pointer and set it to head.
        Node pointer = head;
        
        // Cycle through all of the nodes and display the contents.
        while (pointer != null)
        {
            System.out.print(pointer.value + " ");
            pointer = pointer.next;
        }
    }
    
    /**
     * The main method will test the Node class and the SingleLinkedList
     * methods.
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Create a new SingleLinkedList object.
        SingleLinkedList sll = new SingleLinkedList();
        
        // Add some elements using add and push methods just to establish
        // a base list.
        sll.add("c");
        sll.add("d");
        sll.push("b");
        sll.push("a");
        System.out.print("The base list: ");
        sll.display();
        System.out.print(" Head should be a: " + sll.head.value);
        System.out.println(" Tail should be d: " + sll.tail.value);
        
        //Use insert method to add e after d.
        sll.insert("e", "d");
        System.out.print("Insert e after d: ");
        System.out.print("The new list: ");
        sll.display();
        System.out.print(" Head should be a: " + sll.head.value);
        System.out.println(" Tail should be e: " + sll.tail.value);
        
        //Use insert method to insert x after a.
        sll.insert("x", "a");
        System.out.print("Insert x after a: ");
        System.out.print("The new list: ");
        sll.display();
        System.out.print(" Head should be a: " + sll.head.value);
        System.out.println(" Tail should be e: " + sll.tail.value);
        
        //Use insert method to insert y after d.
        sll.insert("y", "d");
        System.out.print("Insert y after d: ");
        System.out.print("The new list: ");
        sll.display();
        System.out.print(" Head should be a: " + sll.head.value);
        System.out.println(" Tail should be e: " + sll.tail.value);
        
        // Use the delete method to delete the first element a.
        sll.delete("a");
        System.out.print("Delete a: ");
        System.out.print("The new list: ");
        sll.display();
        System.out.print(" Head should be x: " + sll.head.value);
        System.out.println(" Tail should be e: " + sll.tail.value);

        // Use the delete method to delete the element c.
        sll.delete("c");
        System.out.print("Delete c: ");
        System.out.print("The new list: ");
        sll.display();
        System.out.print(" Head should be x: " + sll.head.value);
        System.out.println(" Tail should be e: " + sll.tail.value);
        
        // Use the delete method to delete the last element e.
        sll.delete("e");
        System.out.print("Delete e: ");
        System.out.print("The new list: ");
        sll.display();
        System.out.print(" Head should be x: " + sll.head.value);
        System.out.println(" Tail should be y: " + sll.tail.value);  
    }
}
