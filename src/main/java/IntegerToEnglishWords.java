public class IntegerToEnglishWords implements ISolution {

    private static final String[] ONE_TO_TWENTY = {"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private static final int THOUSAND = 1000;
    private static final int MILLION = 1000000;
    private static final int BILLION = 1000000000;

    private String numberToWords(int num) {
        if(num==0) return "Zero";
        return numberToWordsHelper(num);
    }

    private String numberToWordsHelper(int num){
        String res;
        if(num<20)
            return ONE_TO_TWENTY[num];
        else if(num<100)
            res = TENS[num/10]+" "+ numberToWordsHelper(num%10);
        else if(num<THOUSAND)
            res = numberToWordsHelper(num/100)+" Hundred "+ numberToWordsHelper(num%100);
        else if(num<MILLION)
            res = numberToWordsHelper(num/THOUSAND)+" Thousand "+ numberToWordsHelper(num%THOUSAND);
        else if(num<BILLION)
            res = numberToWordsHelper(num/MILLION)+" Million "+ numberToWordsHelper(num%MILLION);
        else
            res = numberToWordsHelper(num/BILLION)+" Billion "+ numberToWordsHelper(num%BILLION);
        return res.trim();
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[273] Integer to English Words");
        System.out.println("https://leetcode.com/problems/integer-to-english-words/");
        System.out.println();
    }

    @Override
    public void execute() {
        int input = 1234567891;
        String output = numberToWords(input);

        System.out.println("Input: "+ input);
        System.out.println("Output: "+ output);
    }
}
