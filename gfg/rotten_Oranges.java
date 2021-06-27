package gfg;
 import java.util.*;
 
public class rotten_Oranges {

class Solution
{
    class pair
    {
        int first, second, third;
          
        pair(int first,int second,int third)
        {
             this.first = first;
             this.second = second;
             this.third = third;
             
             
        }
    }
     
    // Direction arrays
     int direction[][] = { { 1, 0 }, { 0, -1 },
                            { -1, 0 }, { 0, 1 } };
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
         int m= grid.length ;
         int n =grid[0].length;
         boolean [][]visited =new boolean [m][n];
         
         Queue<pair>q=new LinkedList<>();
         
         
         int fresh=0;
         int time=0;
         
         for(int i=0;i<m;i++)
         {
             for(int j=0;j<n;j++)
             {
                 if(grid[i][j]==2)
                 {
                     q.add(new pair(i,j,0));
                 }
                else  if(grid[i][j]==1)
                 {
                     fresh++;
                    // System.out.println(" row of fresh::"+ i +"  col of fresh  ::"+j);
                     
                 }
                 
             }
             //System.out.println();
         }
         
         while(!q.isEmpty())
         {
             pair current=q.peek();
            //  System.out.println( "cuurent.first="+current.first 
            //  +" current.second="+current.second+
            //  "  current.third="+current.third);
             q.poll();
             
             time=current.third;
             int x=current.first;
             int y=current.second;
              time=current.third;
             //[i-1,j], [i+1,j], [i,j-1], [i,j+1]
          for(int i=0;i<4;i++){
              
              int dx[]={0,0,1,-1};
              int dy[]={1,-1,0,0};
               
               int r=x+dx[i];
               int c=y+dy[i];
               if(!isSafe(r,c,grid,visited)){
                   continue;
               }
               else{
                   // it means that current cell contains 1 
                   q.add(new pair(r,c,time+1));
                   fresh--;
                   visited[r][c]=true;
             //  System.out.print(fresh+"  ");
                   
               }
               
               
          }
         //  System.out.println();
             
             
         }
         
         
         
         
      //   System.out.println(" Total no of Fresh oranges::  "+ fresh);
         int count =0;
      
         if(fresh!=0){
         //    System.out.println(" fresh after Processing all nodes::"+fresh);
           return -1;  
         }
         return time;
         
         
    }
    boolean isSafe(int i,int j,int [][] grid,boolean [][] visited )
    {
        int m=grid.length;
        int n=grid[0].length;
        
        if(i<0||i>=m||j<0||j>=n||grid[i][j]!=1||visited[i][j])
        {
            return false;
        }
        else
        {
        return true;    
        }
    }
}
    
}
