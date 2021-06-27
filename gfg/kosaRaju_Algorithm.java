package gfg;
import java.util.*;

public class kosaRaju_Algorithm

{
    void fillStack(boolean visited[], ArrayList<ArrayList<Integer>> adj,
    Stack<Integer>stack, int V)
    {
        visited[V]=true;
        
        Iterator <Integer> it=adj.get(V).listIterator();
        
        while(it.hasNext())
        {
            int n=it.next();
            if(visited[n]==false)
            {
                fillStack(visited,adj,stack,n);
            }
        }
        stack.push(V);
    }
    //Function to find number of strongly connected components in the graph.
    
    
     ArrayList<ArrayList<Integer>> getTranspose( ArrayList<ArrayList<Integer>> adj
     ,int N)
     {
             ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < N; i++)
            g.add(i, new ArrayList<Integer>());
        for (int v = 0; v < N; v++)
            for (int i = 0; i < adj.get(v).size(); i++)
                g.get(adj.get(v).get(i)).add(v);
        return g;
          
     }
    
    
     void dfs(int v, ArrayList<ArrayList<Integer>> adj,
     boolean[] visited, ArrayList<Integer>component)
     {
         
         //System.out.print( v+"  ");
     
         visited[v]=true;
         
      
          for (int i = 0; i < adj.get(v).size(); i++)
            if (!visited[adj.get(v).get(i)])
                dfs( adj.get(v).get(i),adj, visited,component);
     
         
         component.add(v);
     }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int v=V;
        
       
            boolean visited[]=new boolean [v];
        Stack <Integer>  stack =new Stack<>();
        
        Arrays.fill(visited,false);
        
        for(int i=0 ;i<v;i++)
        {
            if(!visited[i])
            {
                fillStack(visited,adj,stack,i);
            }
            
        }
       
     // now lets create the reverse graph   
     ArrayList<ArrayList<Integer>> reverse=getTranspose(adj,v);
      
     int count=0;
     Arrays.fill(visited,false);
      ArrayList<ArrayList<Integer>> scc = new ArrayList<>();
       
            
            
     while(stack.empty()==false)
     {
         ArrayList<Integer>component=new ArrayList<Integer>();
         
         int top=stack.pop();
         if(!visited[top])
         {
             dfs(top,reverse,visited,component);
             scc.add(component);
            // System.out.println( );
     
         count++;
         }
         
     }
      
      
        return count;
        
    }
} 
    

