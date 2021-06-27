package gfg;

import java.util.*;

class BST {
    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;

        }

        // print a list containing the intersection of the two BSTs in a sorted order
        public static ArrayList<Integer> printCommon(Node root1, Node root2) {
            // add code here.
            ArrayList<Integer> list = new ArrayList<Integer>();
            Set<Integer> set = new HashSet<Integer>();
            bstone(root1, set);
            bsttwo(root2, set, list);
            return list;
        }

        public static void bstone(Node root, Set<Integer> set) {
            if (root == null) {
                return;
            }
            bstone(root.left, set);
            set.add(root.data);
            bstone(root.right, set);

        }

        public static void bsttwo(Node root, Set<Integer> set, ArrayList<Integer> list) {
            if (root == null)
                return;

            bsttwo(root.left, set, list);
            if (set.contains(root.data)) {
                list.add(root.data);
            }
            bsttwo(root.right, set, list);

        }
    }
}
