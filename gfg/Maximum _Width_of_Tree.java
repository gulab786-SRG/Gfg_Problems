package gfg;

import java.util.*;

class Tree {
    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;

        }

        // /* Function to get the maximum width of a binary tree*/
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;

        int getMaxWidth(Node root) {

            int level = 0;
            getcount(root, level);

            // to get the all the value of map
            Collection<Integer> values = map.values();
            ArrayList<Integer> listOfValues = new ArrayList<Integer>(values);
            int max = Integer.MIN_VALUE;
            // now loop to find the maximum value
            for (int ele : listOfValues) {
                if (ele > max) {
                    max = ele;

                }
            }

            return max;
        }

        public void getcount(Node root, int level) {
            if (root == null)
                return;
            level++;
            getcount(root.left, level);
            // System.out.println( " Node Value is::"+ root.data+" "+ "level is:: "+level);

            if (!map.containsKey(level)) {
                map.put(level, count + 1);
            } else {
                int pvalue = map.get(level);
                int nvalue = pvalue + 1;
                map.replace(level, nvalue);

            }
            getcount(root.right, level);
            level--;

        }
    }
}
