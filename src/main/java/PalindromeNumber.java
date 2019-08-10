public class PalindromeNumber implements ISolution {

    private boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reverse = 0;
        while (reverse < x) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[9] Palindrome Number");
        System.out.println("https://leetcode.com/problems/palindrome-number/");
        System.out.println();
    }

    @Override
    public void execute() {
        int input = 121;

        boolean output = isPalindrome(input);

        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}
