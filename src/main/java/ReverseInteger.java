public class ReverseInteger implements ISolution {

    private int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[6] Reverse Integer");
        System.out.println("https://leetcode.com/problems/reverse-integer/");
        System.out.println();
    }

    @Override
    public void execute() {
        int input = 123;
        int output = reverse(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}
