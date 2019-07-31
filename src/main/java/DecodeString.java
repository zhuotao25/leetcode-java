import java.util.Stack;

public class DecodeString implements ISolution {

    /**
     * s = "3[a]2[bc]", return "aaabcbc".
     * s = "3[a2[c]]", return "accaccacc".
     * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     * @param s Input string. e.g., "3[a]2[bc]"
     * @return Decoded string. e.g., "accaccacc"
     */
    private String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        String curr = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                stack.push(curr); // Put current string into stack
                int startIndex = i;
                while(Character.isDigit(s.charAt(i+1)))i++;
                stack.push(s.substring(startIndex,i+1)); // Put multiplier into stack
            }
            else if(c=='['){
                curr = "";
            }
            else if(c==']'){
                int multiplier = Integer.parseInt(stack.pop()); // Get multiplier
                String head = stack.pop(); // Get previous string
                StringBuilder sb = new StringBuilder(head);
                while(multiplier>0){
                    sb.append(curr);
                    multiplier--;
                }
                curr = sb.toString();
            }
            else{
                curr+=c;
            }
        }
        return curr;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[394] Decode String");
        System.out.println("https://leetcode.com/problems/decode-string/");
        System.out.println();
    }

    @Override
    public void execute() {
        String input = "3[a]2[bc]";
        String output = decodeString(input);

        System.out.println("Input: "+input);
        System.out.println("Output: "+output);
    }
}
