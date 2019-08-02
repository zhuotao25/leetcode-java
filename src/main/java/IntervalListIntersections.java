import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections implements ISolution {

    private int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int maxStart = Math.max(A[i][0], B[j][0]);
            int minEnd = Math.min(A[i][1], B[j][1]);
            if (minEnd >= maxStart) {
                res.add(new int[]{maxStart, minEnd});
            }

            if (A[i][1] == minEnd) i++;
            if (B[j][1] == minEnd) j++;
        }
        return res.toArray(new int[0][0]);
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[986] Interval List Intersections");
        System.out.println("https://leetcode.com/problems/interval-list-intersections/");
        System.out.println();
    }

    @Override
    public void execute() {
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};

        int[][] res = intervalIntersection(A,B);

        System.out.println("Input: ");
        System.out.println(Arrays.deepToString(A));
        System.out.println(Arrays.deepToString(B));

        System.out.println("Output: ");
        System.out.println(Arrays.deepToString(res));
    }
}
