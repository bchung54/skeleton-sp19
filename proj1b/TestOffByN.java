import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void testOBN() {
        System.out.println("Testing true cases for OBO");
        assertTrue(offBy5.equalChars('a', 'f'));

        //System.out.println("Testing false cases for OBO");
    }
}
