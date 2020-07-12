import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal implements ISolution {
    @Override
    public void showProblemDetails() {
        System.out.println("#[106] Construct Binary Tree from Inorder and Postorder Traversal");
        System.out.println("https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/");
        System.out.println();
    }

    /*
     inorder = [9,3,15,20,7]
     postorder = [9,15,7,20,3]

         3
        / \
       9   20
          /  \
         15   7
     */
    @Override
    public void execute() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode<Integer> treeNode = buildTree(inorder, postorder);

        System.out.println("Expected inorder: " + Arrays.toString(inorder));
        System.out.println("Expected postorder: " + Arrays.toString(postorder));
        System.out.println("Actual inorder: " + treeNode.inOrderTraversal());
        System.out.println("Actual postorder: " + treeNode.postOrderTraversal());
    }

    public TreeNode<Integer> buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        return build(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode<Integer> build(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int rootIndexInPostorder) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int rootValue = postorder[rootIndexInPostorder];
        TreeNode<Integer> root = new TreeNode<>(rootValue);
        int rightSubTreeLength = 0;
        for (int i = inorderEnd; i >= inorderStart; i--) {
            if (inorder[i] == rootValue) {
                break;
            }
            rightSubTreeLength++;
        }

        root.left = build(inorder, postorder, inorderStart, inorderEnd - rightSubTreeLength - 1, rootIndexInPostorder - rightSubTreeLength - 1 );
        root.right = build(inorder, postorder,inorderEnd - rightSubTreeLength + 1, inorderEnd, rootIndexInPostorder - 1);
        return root;
    }
}
