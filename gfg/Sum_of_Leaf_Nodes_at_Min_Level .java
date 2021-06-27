package gfg;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class GfG2 {
    public int minLeafSum(Node root) {
        // Your Code Here.
        Queue<Node> box = new LinkedList<Node>();
        Node temp = null;
        box.add(root);

        while (!box.isEmpty()) {
            int t = box.size();
            int sum = 0;
            int count = 0;
            while (t-- > 0) {

                temp = box.peek();
                box.poll();

                if (temp.left == null && temp.right == null) {
                    sum = sum + temp.data;
                    count = 1;

                }

                if (temp.left != null) {
                    box.add(temp.left);
                }

                if (temp.right != null) {
                    box.add(temp.right);
                }

            }

            if (count == 1)
                return sum;

        }
        return 0;
    }
}
