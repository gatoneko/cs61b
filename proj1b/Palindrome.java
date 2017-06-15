/**
 * Created by cyoste on 2017/06/15.
 */
public class Palindrome {
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDequeSolution<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public static boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        if (deque.isEmpty()) { return true; }

        while (deque.size() > 1){
            Character last = deque.removeLast();
            Character first = deque.removeFirst();
            if (first != last) {
                return false;
            }
        }
        return true;
    }
}
