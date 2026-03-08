import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

interface PalindromeStrategy {
    boolean checkPalindrome(String word);
}

class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String word) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String word) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";

        PalindromeStrategy strategy;

        strategy = new StackStrategy();
        // strategy = new DequeStrategy();  // switch algorithm here

        if (strategy.checkPalindrome(word)) {
            System.out.println(word + " is a palindrome");
        } else {
            System.out.println(word + " is not a palindrome");
        }
    }
}