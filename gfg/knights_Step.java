package gfg;

import  java.util.*;
public class knights_Step{


class Solution
{
    
    
    
    //Function to find out minimum steps Knight needs to reach target position.
    
    class coordinates{
        int x,y;
        coordinates(int x,int y){
            this.x=x;
            this.y=y;
            
        }
    }
    
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        
        int board [][]=new int [N][N]; 
        
        boolean [][] visited =new boolean   [N][N];
        int sx=KnightPos[0]-1;
        int sy=KnightPos[1]-1;
        
        visited[sx][sy]=true;
                                  
        int dx=TargetPos[0]-1;
        int dy=TargetPos[1]-1;
        int count=0;
        
        Queue<coordinates>q=new LinkedList<>();
        
        q.add(new coordinates(sx,sy));
        
        
        while(!q.isEmpty())
        {
            
            int n=q.size();
                                        

            for(int i=0;i<n;i++)
            {
                
                coordinates coodinate=q.peek();
                q.poll();
                
                for(int k=0;k<8;k++)
                {
                    int co[][]={ {1,2} , {2,1} ,{2,-1} ,{1,-2} ,
                               {-1,-2} ,{-2,-1} ,{-2,1} , {-1,2}};
                               
                               int x=coodinate.x;
                               int y=coodinate.y;
                             
                               if(x==dx&&y==dy)
                               {
                                   return count ;
                               }
                                  

                                            
        
        
                   int r= x+co[k][0];
                   int c= y+co[k][1];
                   
                   
                   if(isSafe(r,c, visited,board))
                   {
                     visited[r][c]=true;
                     q.add(new coordinates(r,c));
                   }
                
                    
                    
                    
                }
                
                
            }
           count++; 
            
        }
        
      return count;  
    }
    boolean isSafe(int r,int c, boolean visited[][] ,int [][] board )
    {
        if(r<0||r>=board.length||c<0||c>=board.length||visited[r][c])
        return false;
        
        else return true;
    }
    
}
} 
