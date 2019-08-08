import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification implements ISolution {

    private List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int len = 0;
        List<String> currWords = new ArrayList<>();
        for (String w : words) {
            if (len + w.length() + 1 <= maxWidth + 1) {
                currWords.add(w);
                len += w.length() + 1;
            } else {
                StringBuilder sb = new StringBuilder(currWords.get(0));
                if (currWords.size() > 1) {
                    int numSpace = maxWidth - len + currWords.size();
                    int numSpaceBetween = numSpace / (currWords.size() - 1);
                    int remainder = numSpace - numSpaceBetween * (currWords.size() - 1);
                    for (int j = 1; j < currWords.size(); j++) {
                        for (int s = 0; s < numSpaceBetween; s++) {
                            sb.append(" ");
                        }
                        if (remainder > 0) {
                            sb.append(" ");
                            remainder--;
                        }
                        sb.append(currWords.get(j));
                    }
                }

                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                res.add(sb.toString());

                len = w.length() + 1;
                currWords.clear();
                currWords.add(w);
            }
        }
        // Last line
        StringBuilder sb = new StringBuilder(currWords.get(0));
        for (int j = 1; j < currWords.size(); j++) {
            sb.append(" ");
            sb.append(currWords.get(j));
        }
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        res.add(sb.toString());

        return res;
    }


    @Override
    public void showProblemDetails() {
        System.out.println("#[68] Text Justification");
        System.out.println("https://leetcode.com/problems/text-justification/");
        System.out.println();
    }

    @Override
    public void execute() {
        String[] input = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        List<String> output = fullJustify(input, maxWidth);

        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Max Width: " + maxWidth);
        System.out.println("Output: " + output);
    }
}
