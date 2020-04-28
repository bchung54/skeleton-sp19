import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {

        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("Noon"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("c"));
    }

    @Test
    public void testPalindromeComp1() {
        OffByOne obo = new OffByOne();

        System.out.println("Testing true cases for CC...");
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertTrue(palindrome.isPalindrome("abxbycb", obo));
        assertTrue(palindrome.isPalindrome("&", obo));

        System.out.println("Testing false cases for CC...");
        assertFalse(palindrome.isPalindrome("chicken", obo));
        assertFalse(palindrome.isPalindrome("&/", obo));
    }

    @Test
    public void testPalindromeCompN() {
        OffByN ob5 = new OffByN(5);
        System.out.println("Testing true cases for CC...");
        assertTrue(palindrome.isPalindrome("fafk", ob5));
        assertTrue(palindrome.isPalindrome("acf", ob5));
        assertTrue(palindrome.isPalindrome("&", ob5));

        System.out.println("Testing false cases for CC...");
        assertFalse(palindrome.isPalindrome("&f", ob5));
    }
}