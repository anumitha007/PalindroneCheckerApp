import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    public static boolean stackPalindrome(String word) {
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

    public static boolean dequePalindrome(String word) {
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

    public static boolean arrayPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        String word = "madam";

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        boolean stackResult = stackPalindrome(word);
        endTime = System.nanoTime();
        System.out.println("Stack Result: " + stackResult);
        System.out.println("Stack Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        boolean dequeResult = dequePalindrome(word);
        endTime = System.nanoTime();
        System.out.println("Deque Result: " + dequeResult);
        System.out.println("Deque Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        boolean arrayResult = arrayPalindrome(word);
        endTime = System.nanoTime();
        System.out.println("Array Result: " + arrayResult);
        System.out.println("Array Time: " + (endTime - startTime) + " ns");
    }
}