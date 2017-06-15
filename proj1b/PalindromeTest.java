/**
 * Created by cyoste on 2017/06/15.
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class PalindromeTest {

    @Test
    public void isPalindromeTest() {
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
        assertTrue(Palindrome.isPalindrome("bab"));
        assertTrue(Palindrome.isPalindrome("abba"));
        assertTrue(Palindrome.isPalindrome("aabaa"));
        assertFalse(Palindrome.isPalindrome("ab"));
    }
}
