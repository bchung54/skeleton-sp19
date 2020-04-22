import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Array;

public class ArrayDequeTest {

    @Test
    public void testSizeEmpty() {
        System.out.println("Testing Size() and isEmpty()");

        ArrayDeque<String> ad1 = new ArrayDeque<>();
        assertEquals(true, ad1.isEmpty());
        assertEquals(0, ad1.size());

        ad1.addFirst("pizza");
        assertEquals(false, ad1.isEmpty());
        assertEquals(1, ad1.size());
    }

    @Test
    public void testaddremoveget() {
        System.out.println("Testing Add / Remove / Get");
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(5);
        ad1.addLast(9);
        ad1.addFirst(4);
        ad1.addFirst(3);
        ad1.addFirst(23);
        ad1.addFirst(2);
        ad1.removeFirst();
        ad1.removeLast();
        ad1.addFirst(15);

        System.out.print("Expected: 15. Actual: " + ad1.get(0));
        System.out.println();
    }

    @Test
    public void testPrint() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(5);
        ad1.addLast(9);
        ad1.addFirst(4);
        ad1.addFirst(3);
        ad1.addFirst(23);
        ad1.addFirst(2);
        ad1.addFirst(2);
        ad1.addFirst(2);
        ad1.addFirst(2);
        ad1.addFirst(2);

        ad1.printArrayDeque();

        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.printArrayDeque();
    }

    @Test
    public void testCopy() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(5);
        ad1.addLast(9);
        ad1.addFirst(4);

        ArrayDeque deepcopy = new ArrayDeque(ad1);
        assertNotEquals(deepcopy, ad1);
    }
}
