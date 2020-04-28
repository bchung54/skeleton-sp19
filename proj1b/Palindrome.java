


public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> outputDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            outputDeque.addLast(word.charAt(i));
        }
        return outputDeque;
    }

    public boolean isPalindrome(String word) {
        Deque deq = wordToDeque(word);
        return isPalindromeHelper(deq);
    }

    private boolean isPalindromeHelper(Deque d) {
        if (d.size() <= 1) {
            return true;
        } else if (d.removeFirst() != d.removeLast()) {
            return false;
        }
        return isPalindromeHelper(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque deq = wordToDeque(word);
        return isPalindromeHelper(deq, cc);
    }

    public boolean isPalindromeHelper(Deque d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        } else if (!cc.equalChars((char)d.removeFirst(), (char)d.removeLast())) {
            return false;
        }
        return isPalindromeHelper(d, cc);
    }
}