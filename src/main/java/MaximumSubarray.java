import java.util.Arrays;

public class MaximumSubarray implements ISolution {

    private int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = max;
        for (int num : nums) {
            if (curr > 0) {
                curr = curr + num;
            } else {
                curr = num;
            }
            max = Math.max(curr, max);
        }
        return max;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[53] Maximum Subarray");
        System.out.println("https://leetcode.com/problems/maximum-subarray/");
        System.out.println();
    }

    @Override
    public void execute() {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int output = maxSubArray(input);
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + output);
    }
}
