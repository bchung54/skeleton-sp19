/** An Integer tester created by Flik Enterprises. */
import static org.junit.Assert.*;

import org.junit.Test;

public class Flik {
    public static boolean isSameNumber(double a, double b) {
        return a == b;
    }

    @Test
    public void testFlik() {
        int x = 5;
        int y = 5;
        assertTrue("Same number, different object", isSameNumber(x, y));
        y = x;
        assertTrue("Same number, same object", isSameNumber(x, y));
        y = 7;
        assertFalse("Different numbers", isSameNumber(x, y));
    }
}
