package gfg;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Tree4 {
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        //
        Queue<Node> box = new LinkedList<Node>();

        ArrayList<Integer> list = new ArrayList<Integer>();

        Stack<Integer> st = new Stack<Integer>();

        box.add(node);
        while (!box.isEmpty()) {

            Node temp = box.peek();

            int tempData = temp.data;

            st.push(tempData);

            if (temp.right != null)
                box.add(temp.right);

            if (temp.left != null)
                box.add(temp.left);

            box.poll();

        }
        int stackSize = st.size();

        for (int i = 0; i < stackSize; i++) {
            int peek = st.pop();
            list.add(peek);

        }
        return list;

    }
}
