package gfg;

public class transformToSumTree {
    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;

        }

    }

    // Asked by Amazon FactSet Microsoft Samsung Walmart
    class Tree {
        public int toSumTree(Node root) {

            if (root == null)
                return 0;
            int temp = root.data;
            root.data = toSumTree(root.left) + toSumTree(root.right);
            return temp + root.data;
        }
    }
}
