import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOBO() {
        System.out.println("Testing true cases for OBO");
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('&', '%'));

        System.out.println("Testing false cases for OBO");
        assertFalse(offByOne.equalChars('a', 't'));
        assertFalse(offByOne.equalChars('%', ')'));
        assertFalse(offByOne.equalChars('A', 'b'));

    }
}