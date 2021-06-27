package gfg;

class GfG_ {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void deleteNode(Node node) {
        // Your code here
        node.data = node.next.data;
        node.next = node.next.next;

    }
}