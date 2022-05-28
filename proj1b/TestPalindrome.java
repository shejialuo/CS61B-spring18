import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

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
    public void testPalindromeNormal() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("cattac"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("e"));
    }

    @Test
    public void testPalindromeOffByOne() {

        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("ab", offByOne));

        assertFalse(palindrome.isPalindrome("noon", offByOne));
        assertFalse(palindrome.isPalindrome("aB", offByOne));
        assertTrue(palindrome.isPalindrome("detrude", offByOne));
    }

    @Test
    public void testPalindromeOffByN() {
        CharacterComparator cc1 = new OffByN(0);
        assertFalse(palindrome.isPalindrome("cat", cc1));
        assertTrue(palindrome.isPalindrome("cattac", cc1));
        assertTrue(palindrome.isPalindrome("a", cc1));
        assertTrue(palindrome.isPalindrome("", cc1));
        assertTrue(palindrome.isPalindrome("racecar", cc1));
        assertTrue(palindrome.isPalindrome("noon", cc1));
        assertTrue(palindrome.isPalindrome("e", cc1));

        CharacterComparator cc2 = new OffByN(1);
        assertTrue(palindrome.isPalindrome("a", cc2));
        assertTrue(palindrome.isPalindrome("", cc2));
        assertTrue(palindrome.isPalindrome("ab", cc2));

        assertFalse(palindrome.isPalindrome("noon", cc2));
        assertFalse(palindrome.isPalindrome("aB", cc2));
    }
}
