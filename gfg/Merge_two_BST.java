package gfg;

import java.util.*;

class Solution {
    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;

        }

        List<Integer> list = new ArrayList<Integer>();

        // Return a integer of integers having all the nodes in both the BSTs in a
        // sorted order.
        public List<Integer> merge(Node root1, Node root2) {
            // Write your code here

            // to get inorder node vlue of tree 1 in the list
            bst1(root1);

            // to get inorder node vlue of tree 2 in the list
            bst2(root2);

            // to get the size of the list
            int n = list.size();

            // array that will contain the all the node value

            int[] f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = list.get(i);

            }
            Arrays.sort(f);
            list.clear();
            for (int i = 0; i < n; i++) {
                list.add(f[i]);

            }
            return list;
        }

        // this gets the values of all node data from the BST 1
        public void bst1(Node root) {
            if (root == null)
                return;
            bst1(root.left);
            list.add(root.data);
            bst1(root.right);

        }

        // this gets the values of all node data from the BST 2
        public void bst2(Node root) {
            if (root == null)
                return;
            bst2(root.left);
            list.add(root.data);
            bst2(root.right);

        }
    }
}
