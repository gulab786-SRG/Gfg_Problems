package gfg;
public class bellManFord_SPA{

class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        // Write your code here
        int [] dist = new int [V];
        
        Arrays.fill(dist ,100000000);
        
        dist[S]=0;
        
        for(int i=0;i<V-1;i++)
        {
            for(int j=0;j<adj.size();j++)
            {
             
             int u=adj.get(j).get(0);
             int v=adj.get(j).get(1);
             int w=adj.get(j).get(2);
             
             if( dist[u]!=100000000&&dist[u]+w<dist[v])
             {
                 dist[v]=dist[u]+w;
             }
             
                
            }
        }
        
       return dist; 
    }
}

}