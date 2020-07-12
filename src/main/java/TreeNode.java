import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;
    public TreeNode() {}
    public TreeNode(T val) { this.val = val; }
    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }

    public List<T> inOrderTraversal() {
        List<T> list = new ArrayList<>();
        inOrderTraversal(this, list);
        return list;
    }

    private void inOrderTraversal(TreeNode<T> root, List<T> list) {
        if (root == null) return;
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }

    public List<T> preOrderTraversal() {
        List<T> list = new ArrayList<>();
        preOrderTraversal(this, list);
        return list;
    }

    private void preOrderTraversal(TreeNode<T> root, List<T> list) {
        if (root == null) return;
        list.add(root.val);
        preOrderTraversal(root.left, list);
        preOrderTraversal(root.right, list);
    }

    public List<T> postOrderTraversal() {
        List<T> list = new ArrayList<>();
        postOrderTraversal(this, list);
        return list;
    }

    private void postOrderTraversal(TreeNode<T> root, List<T> list) {
        if (root == null) return;
        postOrderTraversal(root.left, list);
        postOrderTraversal(root.right, list);
        list.add(root.val);
    }

}