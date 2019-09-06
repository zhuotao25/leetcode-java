import java.util.Arrays;

public class SingleNumber implements ISolution {

    private int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums)
            res ^= i;
        return res;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[136] Single Number");
        System.out.println("https://leetcode.com/problems/single-number/");
        System.out.println();
    }

    @Override
    public void execute() {
        int[] input = {4, 1, 2, 1, 2};
        int output = singleNumber(input);
        System.out.println(Arrays.toString(input));
        System.out.println(output);
    }
}
