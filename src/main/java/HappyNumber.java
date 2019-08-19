import java.util.HashSet;
import java.util.Set;

public class HappyNumber implements ISolution {

    private boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                int num = n % 10;
                sum += num * num;
                n /= 10;
            }
            n = sum;
            if (seen.contains(n)) return false;
            seen.add(n);
        }
        return true;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[202] Happy Number");
        System.out.println("https://leetcode.com/problems/happy-number/");
        System.out.println();
    }

    @Override
    public void execute() {
        int input = 19;
        boolean output = isHappy(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}
