/**
 * LinkedListDeque.java
 *
 * Implementation of circular, doubly linked deque with a sentinel
 * @author bchung
 */

public class LinkedListDeque<Thing> {
    private Node<Thing> sentinel;   // sentinel serves as head and tail
    private int size;               // cache of size of deque

    private static class Node<Thing> {
        private Thing item;             // reference to item stored in this node
        private Node<Thing> next;       // reference to next item in deque
        private Node<Thing> previous;   // reference to previous item in deque

        /**
         * Constructor for a linked list node, given an item
         * @param i the item in the node
         */
        public Node(Thing i) {
            item = i;               // copy reference of item
            next = previous = null; // no element before or after
        }
    }

    /**
     * Constructor for a circular, doubly linked deque with a sentinel
     * Makes an empty deque
     */
    public LinkedListDeque() {
        sentinel= new Node<Thing>(null);
        sentinel.next = sentinel.previous = sentinel;
        size = 0;
    }

    /**
     * Creates a deep copy of linked list deque entered
     * @param other the other linked list deque to deep copy
     */
    public LinkedListDeque(LinkedListDeque<Thing> other) {
        sentinel = new Node<Thing>(null);
        sentinel.next = sentinel.previous = sentinel;
        size = 0;
        for (int i = 0; i < other.size(); i++) {
            addLast(other.get(i));
        }
    }

    /**
     * Adds node to front of deque
     * @param item the item to place in first node
     */
    public void addFirst(Thing item) {
        Node<Thing> first = new Node<>(item);       // allocate a new node

        // splice in new node into front of deque
        first.next = sentinel.next;
        first.previous = sentinel;
        sentinel.next.previous = first;
        sentinel.next = first;

        size++;                                     // increment size by 1
    }

    /**
     * Adds node to back of deque
     * @param item the item to place in last node
     */
    public void addLast(Thing item) {
        Node<Thing> last = new Node<>(item);        // allocate a new node

        // splice in new node into back of deque
        last.next = sentinel;
        last.previous = sentinel.previous;
        sentinel.previous.next = last;
        sentinel.previous = last;

        size++;                                     // increment size by 1
    }

    /**
     * Checks if the deque is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    /**
     * Gives size of the deque
     * @return integer of the size of the deque
     */
    public int size() {
        return size;
    }

    /**
     * Prints out each item of deque in order, separated by a space and ended with a new line
     */
    public void printDeque() {
        Node<Thing> pointer = sentinel.next;
        while (pointer != sentinel) {
            System.out.print(pointer.item);
            System.out.print(" ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    /**
     * Removes the first node of deque
     * @return the item that was contained in the first node
     */
    public Thing removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Thing output = sentinel.next.item;          // allocate a new thing to store item for output

            // splice out first node
            sentinel.next.next.previous = sentinel;
            sentinel.next = sentinel.next.next;

            size--;                                     // decrement size by 1
            return output;
        }
    }

    /**
     * Removes the last node of deque
     * @return the item that was contained in the last node
     */
    public Thing removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            Thing output = sentinel.previous.item;              // allocate a new thing to store item for output

            // splice out last node
            sentinel.previous.previous.next = sentinel;
            sentinel.previous = sentinel.previous.previous;

            size--;                                             // decrement size by 1
            return output;
        }
    }

    /**
     * Grabs and returns the item in the deque of certain index iteratively
     * @param index the index of the item to get
     * @return item within the deque of index parameter, null if index out of bounds
     */
    public Thing get(int index) {
        Node<Thing> pointer = sentinel;
        int counter = 0;

        while (pointer.next != sentinel) {
            pointer = pointer.next;
            if (counter == index) {
                return pointer.item;
            }
            counter++;
        }
        return null;
    }

    /**
     * Grabs and returns the item in the deque of certain index recursively
     * @param index the index of the item to get
     * @return item within the deque of index parameter, null if index out of bounds
     */
    public Thing getRecursive(int index) {
        if (index >= size || index < 0){
            return null;
        }
        return getRecurHelper(index, sentinel.next);
    }

    public Thing getRecurHelper(int index, Node<Thing> pointer) {
        if (index == 0) {
            return pointer.item;
        }
        return getRecurHelper(index - 1, pointer.next);
    }
}