import java.util.InputMismatchException;
import java.util.Scanner;

public class LeetCodeCracker {

    public static void main(String[] args) {

        pickProblem();

    }

    private static void pickProblem(){
        // Get problem number from console input
        int id;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("Please enter problem number: ");
                    id = scanner.nextInt();
                    break;
                } catch (InputMismatchException ex) {
                    scanner.next();
                }
            }
        }

        // Execute the solution
        executeSolution(id);
    }

    private static void executeSolution(int id){

        ISolution solution;
        switch (id) {
            case 6: solution = new ReverseInteger(); break;
            case 9: solution = new PalindromeNumber(); break;
            case 13: solution = new RomanToInteger(); break;
            case 14: solution = new LongestCommonPrefix(); break;
            case 21: solution = new MergeTwoSortedLists(); break;
            case 53: solution = new MaximumSubarray(); break;
            case 67: solution = new AddBinary(); break;
            case 68: solution = new TextJustification(); break;
            case 88: solution = new MergeSortedArray(); break;
            case 101: solution = new SymmetricTree(); break;
            case 106: solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal(); break;
            case 125: solution = new ValidPalindrome(); break;
            case 136: solution = new SingleNumber(); break;
            case 141: solution = new LinkedListCycle(); break;
            case 160: solution = new IntersectionOfTwoLinkedLists(); break;
            case 202: solution = new HappyNumber(); break;
            case 204: solution = new CountPrimes(); break;
            case 273: solution = new IntegerToEnglishWords(); break;
            case 283: solution = new MoveZeroes(); break;
            case 332: solution = new ReconstructItinerary(); break;
            case 344: solution = new ReverseString(); break;
            case 394: solution = new DecodeString(); break;
            case 412: solution = new FizzBuzz(); break;
            case 981: solution = new TimeBasedKeyValueStore(); break;
            case 986: solution = new IntervalListIntersections(); break;
            default: solution = new DefaultSolution(id); break;
        }

        System.out.println("\nStart executing solution for problem #["+id+"]");
        System.out.println("==============================================");
//        long startTime = System.nanoTime();

        // Show problem details
        solution.showProblemDetails();
        // Execute the solution
        solution.execute();

//        long endTime = System.nanoTime();
//        long timeElapsed = endTime - startTime;
//        System.out.println("==============================================");
//        System.out.println("Execution time in nanoseconds: " + timeElapsed);
//        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
    }
}
