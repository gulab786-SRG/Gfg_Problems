package gfg;
import java.util.*;
 public class detect_Negative_Cycle{

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        
    
    int dist [] =new int [n];
    
    Arrays.fill(dist , Integer.MAX_VALUE);
    
    dist [0]=0;
    
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<edges.length;j++)
        {
            int u=edges[j][0];
            int v=edges[j][1];
            int w=edges[j][2];
            
            if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v])
            {
                dist[v]=dist[u]+w;
            }
        }
    }
    
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<edges.length;j++)
        {
            
            int u=edges[j][0];
            int v=edges[j][1];
            int w=edges[j][2];
            
            if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v])
            {
               return 1;
            }
        }
    }
    return 0; 
    }
}
 }