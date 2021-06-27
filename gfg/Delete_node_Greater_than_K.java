package gfg;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Gfg {
    Node temp = null;

    public Node deleteNode(Node root, int k) {
        if (root == null)
            return root;

        if (root.data >= k) {
            root.right = null;

            return deleteNode(root.left, k);
        }

        else {
            root.right = deleteNode(root.right, k);
            return root;
        }

    }

}