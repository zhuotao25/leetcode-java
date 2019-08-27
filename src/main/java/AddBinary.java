public class AddBinary implements ISolution {

    private String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1, j = b.length() - 1, carrier = 0;
        while (i >= 0 || j >= 0) {
            char x = i >= 0 ? a.charAt(i--) : '0';
            char y = j >= 0 ? b.charAt(j--) : '0';

            int sum = Character.getNumericValue(x) + Character.getNumericValue(y) + carrier;
            carrier = sum / 2;
            sb.insert(0, sum % 2);
        }
        if (carrier > 0) sb.insert(0, '1');
        return sb.toString();
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[67] Add Binary");
        System.out.println("https://leetcode.com/problems/add-binary/");
        System.out.println();
    }

    @Override
    public void execute() {
        String input1 = "11";
        String input2 = "1";
        String output = addBinary(input1, input2);
        System.out.println("Input: " + input1 + ", " + input2);
        System.out.println("Output: " + output);
    }
}
