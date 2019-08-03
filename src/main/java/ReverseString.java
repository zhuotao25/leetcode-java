import java.util.Arrays;

public class ReverseString implements ISolution {

    private void reverseString(char[] s) {
        if(s!=null){
            int i = 0;
            int j = s.length-1;
            while(i<=j){
                char temp = s[i];
                s[i]=s[j];
                s[j]=temp;
                i++;
                j--;
            }
        }
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[344] Reverse String");
        System.out.println("https://leetcode.com/problems/reverse-string/");
        System.out.println();
    }

    @Override
    public void execute() {
        char[] input = {'h','e','l','l','o'};
        System.out.println("Input: " + Arrays.toString(input));

        reverseString(input);

        System.out.println("Output: " + Arrays.toString(input));
    }
}
