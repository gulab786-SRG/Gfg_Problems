package gfg;

import java.util.*;

//User function Template for Java

// Node class of the binary tree
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Tree {
    public static void printCorner(Node node) {

        Queue<Node> box = new LinkedList<Node>();

        box.add(node);

        Node temp = null;

        while (!box.isEmpty()) {
            int t = box.size();

            for (int i = 0; i < t; i++) {

                temp = box.poll();
                // this will remove the elements so that
                // elements between the birst and corner will be remain

                {
                    // printing will take place only if element is..
                    // .. either first or last element will

                    if (i == 0 || i == t - 1)
                        System.out.print(temp.data + " ");
                }

                // adding the left nd right elemnts between the
                // corner element
                if (temp.left != null)
                    box.add(temp.left);

                if (temp.right != null)
                    box.add(temp.right);

            }
        }
    }

}
