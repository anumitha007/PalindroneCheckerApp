class PalindromeChecker {

    public boolean checkPalindrome(String word) {
        char[] chars = word.toLowerCase().toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String word = "Level";

        PalindromeChecker checker = new PalindromeChecker();

        if (checker.checkPalindrome(word)) {
            System.out.println(word + " is a palindrome");
        } else {
            System.out.println(word + " is not a palindrome");
        }
    }
}