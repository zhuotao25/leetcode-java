import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal implements ISolution {
    @Override
    public void showProblemDetails() {
        System.out.println("#[105] Construct Binary Tree from Preorder and Inorder Traversal");
        System.out.println("https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/");
        System.out.println();
    }


    /*
     preorder = [3,9,20,15,7]
     inorder = [9,3,15,20,7]

         3
        / \
       9   20
          /  \
         15   7
     */
    @Override
    public void execute() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 15, 7, 20, 3};

        TreeNode<Integer> treeNode = buildTree(preorder, inorder);

        System.out.println("Expected inorder: " + Arrays.toString(inorder));
        System.out.println("Expected preorder: " + Arrays.toString(preorder));
        System.out.println("Actual inorder: " + treeNode.inOrderTraversal());
        System.out.println("Actual preorder: " + treeNode.preOrderTraversal());
    }

    private TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode<Integer> helper(int[] preorder, int[] inorder, int rootIndexPreorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(preorder[rootIndexPreorder]);
        int leftSubTreeLength = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                break;
            }
            leftSubTreeLength++;
        }
        root.left = helper(preorder, inorder, rootIndexPreorder + 1, inStart, inStart + leftSubTreeLength -1);
        root.right = helper(preorder, inorder, rootIndexPreorder + leftSubTreeLength + 1,  inStart + leftSubTreeLength + 1, inEnd);
        return root;
    }
}
