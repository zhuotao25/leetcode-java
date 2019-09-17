public class CountPrimes implements ISolution {

    private int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[204] Count Primes");
        System.out.println("https://leetcode.com/problems/count-primes/");
        System.out.println();
    }

    @Override
    public void execute() {
        int input = 10;
        int output = countPrimes(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}
