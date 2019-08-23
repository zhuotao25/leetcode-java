import java.util.Arrays;

public class MoveZeroes implements ISolution {

    private void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[i] == 0) {
                while (j + 1 < nums.length && nums[j] == 0) {
                    j++;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
            i++;
            j++;
        }
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[283] Move Zeroes");
        System.out.println("https://leetcode.com/problems/move-zeroes/");
        System.out.println();
    }

    @Override
    public void execute() {
        int[] input = {0, 1, 0, 3, 12};
        System.out.println("Input: " + Arrays.toString(input));
        moveZeroes(input);
        System.out.println("Output: " + Arrays.toString(input));
    }
}
