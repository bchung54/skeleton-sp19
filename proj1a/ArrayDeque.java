/**
 * ArrayDeque.java
 *
 * Implementation of circular, doubly linked array deque with a sentinel
 * @author bchung
 */
public class ArrayDeque<T> {
    private T[] items;                  // sentinel serves as head and tail
    private int size;                   // cache of size of deque
    private int nextFirst;
    private int nextLast;
    private final int INIT_CAPACITY = 8;

    /**
     * Creates an empty array.
     */
    public ArrayDeque() {
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /**
     * Creates a copy of another array.
     * @param other array that should be deep copied.
     */
    public ArrayDeque(ArrayDeque<T> other) {
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        nextFirst = other.nextFirst;
        nextLast = nextFirst + 1;

        for (int i = 0; i < other.size(); i++) {
            addLast(other.get(i));
        }
    }

    private int nextOne(int index) {
        return Math.floorMod(index + 1, items.length);
    }

    private int prevOne(int index) {
        return Math.floorMod(index - 1, items.length);
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize() {
        if (size == items.length) {
            resizeCopyOver(items.length * 2);
        } else if (size < items.length / 4 && items.length > 8) {
            resizeCopyOver(items.length / 2);
        }
    }

    private void resizeCopyOver(int capacity) {
        T[] newItemsHolder = (T[]) new Object[capacity];
        int lastCopy = 1;
        nextFirst = nextOne(nextFirst);
        nextLast = prevOne(nextLast);
        for (int i = nextFirst; i != nextLast; i = nextOne(i)) {
            newItemsHolder[lastCopy] = items[i];
            lastCopy++;
        }
        newItemsHolder[lastCopy] = items[nextLast];
        items = newItemsHolder;
        nextFirst = 0;
        nextLast = lastCopy + 1;
    }

    /**
     * Inserts item into the first element of array.
     * @param item the item to be inserted.
     */
    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = prevOne(nextFirst);
        size++;
        resize();
    }

    /**
     * Inserts item into the last element of array.
     * @param item the item to be inserted.
     */
    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = nextOne(nextLast);
        size++;
        resize();
    }

    /**
     * Checks if array is empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() { return size == 0;}

    /** Returns size of array. */
    public int size() { return size; }

    /**
     * Prints items in array in order separated by a space.
     */
    public void printArrayDeque() {
        int arrayIndex = nextOne(nextFirst);
        while (arrayIndex != nextLast) {
            System.out.print(items[arrayIndex]);
            System.out.print(" ");
            arrayIndex = nextOne(arrayIndex);
        }
        System.out.println();
    }

    /**
     * Removes first element in array and returns it.
     * @return item in the element being removed.
     */
    public T removeFirst() {
        nextFirst = nextOne(nextFirst);
        T out = items[nextFirst];
        size--;
        resize();
        return out;
    }

    /**
     * Removes last element in array and returns it.
     * @return item in the element being removed.
     */
    public T removeLast() {
        nextLast = prevOne(nextLast);
        T out = items[nextLast];
        size--;
        resize();
        return out;
    }

    /** Returns the item from given index of array. */
    public T get(int index) {
        if (index < 0  || index >= size) {
            return null;
        }
        return items[nextOne(index + nextFirst)];
    }
}