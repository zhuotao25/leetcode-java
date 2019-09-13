import java.util.Arrays;

public class MergeSortedArray implements ISolution {

    private void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        while (m > 0 || n > 0) {
            int a = m > 0 ? nums1[m - 1] : Integer.MIN_VALUE;
            int b = n > 0 ? nums2[n - 1] : Integer.MIN_VALUE;
            if (a > b) {
                nums1[i] = a;
                m--;
            } else {
                nums1[i] = b;
                n--;
            }
            i--;
        }
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[88] Merge Sorted Array");
        System.out.println("https://leetcode.com/problems/merge-sorted-array/");
        System.out.println();
    }

    @Override
    public void execute() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        System.out.println("Input: " + Arrays.toString(nums1) + "," + Arrays.toString(nums2));

        merge(nums1, 3, nums2, 3);

        System.out.println("Input: " + Arrays.toString(nums1));
    }
}
