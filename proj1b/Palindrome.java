public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        if (word.isEmpty()) {
            return null;
        }
        Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    private boolean isPalindromeHelper(Deque<Character> deque) {
        if (deque.isEmpty() || deque.size() == 1) {
            return true;
        }
        if (deque.removeFirst().equals(deque.removeLast())) {
            return isPalindromeHelper(deque);
        } else {
            return false;
        }
    }

    private boolean isPalindromeHelper(Deque<Character> deque, CharacterComparator cc) {
        if (deque.isEmpty() || deque.size() == 1) {
            return true;
        }
        if (cc.equalChars(deque.removeFirst(), deque.removeLast())) {
            return isPalindromeHelper(deque, cc);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addFirst(word.charAt(i));
        }
        return isPalindromeHelper(deque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        }
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addFirst(word.charAt(i));
        }
        return isPalindromeHelper(deque, cc);
    }
}
