package gfg;

class SolutionT {
    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;

        }

        Node head = null;
        Node prev = null;
        int leaf = 0;

        public Node convertToDLL(Node root) {
            if (root == null)
                return null;

            Node left = convertToDLL(root.left);

            // this is to remove leaf node at left subtree
            if (leaf == 1) {
                root.left = null;
                leaf = 0;
            }

            Node right = convertToDLL(root.right);

            // this is to remove leaf node at right subtree
            if (leaf == 1) {
                root.right = null;
                leaf = 0;
            }

            if (left == null && right == null) {
                leaf = 1;

                if (head == null)
                    head = root;

                else {
                    prev.right = root;
                    root.left = prev;
                }

                prev = root;

            }

            return head;
        }
    }
}
