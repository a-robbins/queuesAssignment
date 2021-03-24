import java.util.Iterator;

public class GenericList<Item> implements Iterable<Item> {

    /**
     * Define the node object will be used to represent each element of our linked
     * list. This should be modified such that we are using a doubly linked list
     */
    private class Node {
        Item val;
        Node next;
        Node prev;

        public Node(Item v) {
            val = v;
            next = null;
            prev = null;
        }
    }

    /***************************************************************************
     * Instance variables
     *
     * The private variables that will be available to each instance of our class
     * You may add new instance variables here if you wish, make sure to init them
     * properly in the constructor
     **************************************************************************/
    private Node head;
    private Node tail;
    private int currSize;

    /***************************************************************************
     * Instance methods
     *
     * Theses are the methods that will be available to each instance of our class,
     * this is also where the public api is defined with the `public` modifier.
     * You may _not_ modify an existing method prototypes or add any new _public_
     * methods, but you may add new _private_ methods as helper functions.
     **************************************************************************/

    /**
     * List constructor, called when a new instance of our class is created. This
     * should initialize all instance variables to a known state.
     */
    public GenericList() {
        head = null;
        tail = null;
        currSize = 0;
    }

    /**
     * Prints the contents of the list from front to back.
     */
    public void print() {
        Node walker = head;
        StdOut.print("head --> ");
        print(head);
        StdOut.print("null\n");
    }

    /**
     * recursive print helper function
     *
     * @param n A reference to the node that should be printed
     */
    private void print(Node n) {
        if (n == null) {
            return;
        }
        StdOut.print(n.val);
        StdOut.print(" --> ");
        print(n.next);
    }

    /**
     * Inserts a new node at the end of the list
     *
     * @param val The value to be inserted
     */
    public boolean insertBack(Item val) {
        Node n = new Node(val);

        if (head == null) {
            head = n;
            tail = n;
        }
        else {
            n.prev = tail;
            tail.next = n;
            tail = n;
        }
        currSize++;
        return true;
    }

    /**
     * Removes the front node from the list
     */
    public void deleteFront() {
        if (head != null) {
            head = head.next;

            // check to make sure we didn't just remove the last node in the list
            if (head != null) {
                head.prev = null;
            }
            else {
                tail = null;
            }
            currSize--;
        }
    }

    /**
     * Get the current number of nodes in the linked list
     *
     * @return The current number of node sin the list
     */
    public int getSize() {
        return currSize;
    }

    /**
     * Get the value located at the front of the list
     *
     * @return the value or null if list is empty
     */
    Item getFront() {
        if (head != null) {
            return head.val;
        }
        else {
            return null;
        }
    }

    public boolean isEmpty() {
        if (currSize == 0) {
            return true;
        }
        return false;
    }

    public Iterator<Item> iterator() {
        return new GenericListIterator();
    }

    private class GenericListIterator implements Iterator<Item> {
        private Node curr = head;

        public boolean hasNext() {
            return curr != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            Item val = curr.val;
            curr = curr.next;
            return val;
        }

    }

    public static void main(String[] args) {
        GenericList<Integer> ll = new GenericList<Integer>();

        for (int i = 0; i < 25; i++) {
            ll.insertBack(i);
        }

        for (Integer i : ll) {
            StdOut.println(i);
        }
    }
}
