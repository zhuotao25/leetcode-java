public class DefaultSolution implements ISolution {

    private int id;

    DefaultSolution(int id){
        this.id = id;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("https://leetcode.com/problemset/algorithms/\n");
    }

    @Override
    public void execute() {
        System.out.println("No solution yet for problem #["+id+"]!");
    }

}
