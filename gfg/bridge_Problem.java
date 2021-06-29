package gfg;
import java.util.*;

public class bridge_Problem {
    class Solution
{
    //Function to find if the given edge is a bridge in graph.
     int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        boolean [] visited1 =new boolean [V];
        int count1=0;
        for(int i=0;i<V;i++)
        {
            if(!visited1[i])
            {
                dfs(i,visited1,adj);
              ///  System.out.println();
            count1++;
            }
             
        }
        
        
        for(int i=0;i<adj.get(c).size();i++)
        {
            if(adj.get(c).get(i)==d)
            {
                adj.get(c).remove(i);
                break;
            }
        }
        for(int i=0;i<adj.get(d).size();i++)
        {
            if(adj.get(d).get(i)==c)
            {
                adj.get(d).remove(i);
                break;
            }
        }
        
        boolean [] visited2 =new boolean [V];
        int count2=0;
        for(int i=0;i<V;i++)
        {
            if(!visited2[i])
            {
                dfs(i,visited2,adj);
              ///  System.out.println();
            count2++;
            }
             
        }
        
        if(count1==count2)
        {
            return 0;
        }
        return 1;
        
       
        
    }
   public   void dfs( int i,boolean [] visited,ArrayList<ArrayList<Integer>> adj)
    {
        visited[i]=true;
        //System.out.print(i+" -> ");
        
        Iterator<Integer>it=adj.get(i).listIterator();
        while(it.hasNext())
        {
            int n=it.next();
            if(!visited[n])
            {
                dfs(n,visited,adj);
            }
        }
    }
}
}
