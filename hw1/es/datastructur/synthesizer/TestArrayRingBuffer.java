package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(3);
        arb.enqueue(2);
        arb.enqueue(4);
        arb.enqueue(6);
        arb.dequeue();
        arb.enqueue(5);

        ArrayRingBuffer<Integer> arc = new ArrayRingBuffer(3);
        arc.enqueue(2);
        arc.enqueue(6);
        arc.enqueue(4);

        ArrayRingBuffer<Integer> ard = new ArrayRingBuffer(3);
        ard.enqueue(2);
        ard.enqueue(4);
        ard.enqueue(6);
        ard.dequeue();
        ard.enqueue(5);

        assertFalse(arb.equals(arc));
        assertTrue(arb.equals(ard));
        assertEquals(3, ard.fillCount());
    }
}
