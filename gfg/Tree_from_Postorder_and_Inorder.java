
// there are two approach 
// one with  for loop with time complexity of O(N^2) and another one 
// with hash map with time complexity of O(N);
// optimized method is given without comments and  unoptimized 
// is given in comments so anyone can be use ( optimized is prefered)
package gfg;

import java.util.*;

class GfG {
    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;

        }

        // Complete the function
        int postindex = 0;

        Node buildTree(int in[], int post[], int n) {
            // Your code here
            int st = 0;
            int end = n - 1;
            postindex = n - 1;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int i = 0; i < n; i++) {
                map.put(in[i], i);
            }
            return build(in, post, st, end, map);
            // return build(in , post , st ,end );

        }

        public Node build(int[] inorder, int[] postorder, int start, int end, Map<Integer, Integer> map) {
            if (start > end)
                return null;

            Node node = new Node(postorder[postindex--]);
            int index = map.get(node.data);
            // int index=-1;
            // for(int i=start;i<=end;i++){
            // if(inorder[i]==node.data)
            // {
            // index=i;
            // break;
            // }
            // }

            // node.right= build(inorder,postorder,index+1,end);
            // node .left=build(inorder,postorder,start,index-1);
            node.right = build(inorder, postorder, index + 1, end, map);
            node.left = build(inorder, postorder, start, index - 1, map);

            return node;

        }

    }
}
