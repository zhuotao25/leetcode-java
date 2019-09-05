import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree implements ISolution {

    private boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSymmetricHelper(left.right, right.left) && isSymmetricHelper(left.left, right.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[101] Symmetric Tree");
        System.out.println("https://leetcode.com/problems/symmetric-tree/");
        System.out.println();
    }

    @Override
    public void execute() {
//            1
//           / \
//          2   2
//         / \ / \
//        3  4 4  3
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(3);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;

        boolean output = isSymmetric(root);

        System.out.println("Input: ");
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        int end = 1;
        while (!q.isEmpty()) {
            if (count == end) {
                System.out.println();
                count = 0;
                end = q.size();
            }
            TreeNode n = q.poll();
            assert n != null;
            System.out.print(n.val);
            count++;
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        System.out.println();

        System.out.println("Output: " + output);
    }
}
