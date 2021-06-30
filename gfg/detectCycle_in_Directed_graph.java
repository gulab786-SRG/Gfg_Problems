package gfg;
import java.util.*;
public class detectCycle_in_Directed_graph {
    
class Solution 
{
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code hereint 
        int v=V;

        boolean [] visited =new boolean [v];
        boolean recStack [] =new boolean [v];
        
        for(int i=0;i<v;i++)
        {
          
                if(dfs(i,visited,recStack,adj))
                {
                    return true;
                }
                
            
        }

        
return false;
    }
    boolean dfs(int i,boolean visited[],boolean []recStack,
    ArrayList<ArrayList<Integer>> adj)
    {
        if(recStack[i])
        return true;
        
        if(visited[i])
        return false;
         visited[i]=true;
    recStack[i]=true;

ArrayList<Integer> list =adj.get(i);

for(int ele:list){
    if(dfs(ele,visited,recStack,adj))
    return true;
}

recStack[i]=false;
  
    return false;
    }
   
    
}
}
