// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        
        // 
        int  graph[][]=new int [V][V];
        for(int i=0;i<V;i++){
            Arrays.fill(graph[i], 0);
        }

        int arr[];
      //  System.out.println("After filling all elements = "+ Arrays.deepToString(graph));
       
      for(int i=0;i<V;i++){
          Iterator <ArrayList<Integer>>it=adj.get(i).listIterator();
          while(it.hasNext()){
              int u,v,w;
              ArrayList<Integer> current=it.next();

              u=i;
              v=current.get(0);
              w=current.get(1);
              graph[u][v]=w;


          }
      }
       
       int sum=finMST(graph,V);
       return sum;
        
    }
    static int finMST(int graph[][],int V){
         // Add your code here
        int parent [] =new int [V];
        int key []=new int [V];
        boolean []mstset=new boolean[V];

        
        Arrays.fill(key,Integer.MAX_VALUE);
        Arrays.fill(mstset,false);
           key[0]=0;
           parent[0]=-1;
           
           
           for(int  count =0;count<V;count++){
                int u=minKey(key,mstset);
                
           mstset[u]=true;     
                for(int v=0;v<V;v++){
                    
                    if(graph[u][v]!=0 &&mstset[v]==false && graph[u][v]<key[v]){
                        parent[v]=u;
                        key[v]=graph[u][v];
                        
                    }
                }
           }
           int minSum=0;
           
           for( int  keyValue:key){
               minSum=minSum+keyValue;
           }
           return minSum;
    }
    static int minKey(int [] key ,boolean [] mstset){
        
        int index=-1, minKey=Integer.MAX_VALUE;
        for(int i=0;i<key.length;i++){
            if(mstset[i]==false&&key[i]<minKey){
                minKey=key[i];
                index=i;
            }
        }
        return index;
    }
}
