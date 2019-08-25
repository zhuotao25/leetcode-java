import java.util.ArrayList;
import java.util.List;

public class FizzBuzz implements ISolution {

    private List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[412] Fizz Buzz");
        System.out.println("https://leetcode.com/problems/fizz-buzz/");
        System.out.println();
    }

    @Override
    public void execute() {
        int input = 15;
        List<String> output = fizzBuzz(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}
