import java.util.Arrays;

public class LongestCommonPrefix implements ISolution {

    private String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            common = findCommonPrefix(common, strs[i]);
            if (common.isEmpty()) return common;
        }
        return common;
    }

    private String findCommonPrefix(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                sb.append(a.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[14] Longest Common Prefix");
        System.out.println("https://leetcode.com/problems/longest-common-prefix/");
        System.out.println();
    }

    @Override
    public void execute() {
        String[] input = {"flower", "flow", "flight"};
        String output = longestCommonPrefix(input);
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + output);
    }
}
