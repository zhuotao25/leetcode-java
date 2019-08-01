public class RomanToInteger implements ISolution {

    /**
     * Input: "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     * @param s Raman string
     * @return Number
     */
    private int romanToInt(String s) {
        int num = 0;
        int prev = 1001;
        int curr = 0;
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(c=='M'){
                curr = 1000;
            }
            else if(c=='D'){
                curr = 500;
            }
            else if(c=='C'){
                curr = 100;
            }
            else if(c=='L'){
                curr = 50;
            }
            else if(c=='X'){
                curr = 10;
            }
            else if(c=='V'){
                curr = 5;
            }
            else if(c=='I'){
                curr = 1;
            }
            num+=curr;
            if(prev<curr){
                num-=2*prev;
            }
            prev = curr;
        }
        return num;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[13] Roman to Integer");
        System.out.println("https://leetcode.com/problems/roman-to-integer/");
        System.out.println();
    }

    @Override
    public void execute() {
        String input = "MCMXCIV";
        int num = romanToInt(input);

        System.out.println("Input: "+input);
        System.out.println("Output: "+num);
    }
}
