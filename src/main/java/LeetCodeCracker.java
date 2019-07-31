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
                    System.out.println("Please enter a number: ");
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
        //TODO: add more case when there are new solutions
        if (id == 394) {
            solution = new DecodeString();
        } else {
            solution = new DefaultSolution(id);
        }

        System.out.println("\nStart executing solution for problem #["+id+"]");
        System.out.println("/==============================================\\");
        long startTime = System.nanoTime();

        // Show problem details
        solution.showProblemDetails();
        // Execute the solution
        solution.execute();

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("\\==============================================/");
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
    }
}
