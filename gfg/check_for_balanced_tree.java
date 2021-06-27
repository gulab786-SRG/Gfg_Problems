package gfg;

// ASKED BY WALMART AND MICROSOFT 
public class check_for_balanced_tree {
    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;

        }
    }

    boolean isBalanced(Node root) {
        if (root == null)
            return true;
        // Your code here
        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) < 2 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        else
            return false;

    }

    int height(Node node) {
        if (node == null)
            return 0;
        int x = height(node.left) + 1;
        int y = height(node.right) + 1;
        if (x > y)
            return x;
        else
            return y;

    }
}
