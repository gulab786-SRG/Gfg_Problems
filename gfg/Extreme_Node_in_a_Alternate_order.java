package gfg;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class Tree3 {
    public ArrayList<Integer> ExtremeNode(Node node) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Node> box = new LinkedList<Node>();
        int level = 1;
        box.add(node);

        while (!box.isEmpty()) {
            ArrayList<Integer> tel = new ArrayList<Integer>();
            int t = box.size();

            for (int i = 0; i < t; i++) {
                Node temp = box.peek();
                //
                tel.add(temp.data);

                if (temp.left != null)
                    box.add(temp.left);
                if (temp.right != null)
                    box.add(temp.right);

                box.poll();
            }

            if (level % 2 == 0) {
                list.add(tel.get(0));
            } else {
                list.add(tel.get(t - 1));
            }

            level++;

        }
        return list;
    }
}