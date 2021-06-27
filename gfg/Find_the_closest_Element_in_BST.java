package gfg;

class tre {
    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;

        }

        static int sol = 0;

        // Return the minimum absolute difference between any tree node and the integer
        // K
        static int maxDiff(Node root, int K) {

            int s = Integer.MAX_VALUE;

            lowest(root, K, s);

            return sol;
        }

        public static void lowest(Node root, int k, int s) {
            if (root == null)
                return;

            int diff = Math.abs(k - root.data);

            s = Math.min(s, diff);
            sol = s;

            if (k > root.data)
                lowest(root.right, k, s);
            else
                lowest(root.left, k, s);

        }
    }
}
