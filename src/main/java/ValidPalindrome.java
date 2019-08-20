public class ValidPalindrome implements ISolution {

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) return false;
        }
        return true;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[125] Valid Palindrome");
        System.out.println("https://leetcode.com/problems/valid-palindrome/");
        System.out.println();
    }

    @Override
    public void execute() {
        String input = "\"A man, a plan, a canal: Panama\"";
        boolean output = isPalindrome(input);

        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}
