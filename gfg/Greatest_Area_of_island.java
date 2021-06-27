package Gfg_Solution.gfg;

public class Greatest_Area_of_island {
    int count;
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
   
        int m = grid.length;
        int n = grid[0].length;
   
     

      int result=0;
   
     boolean visited[][] = new boolean[m][n];
     
     for(int i= 0;i <m ;i++){
          
          
          for(int j=0; j<n ;j++){
              
              if(grid[i][j]==1 && !visited[i][j])
              {
                  count=1;
                  
                  dfs(i,j,grid,visited);
                  
                  result=Math.max( result , count );
                  
              }
          }
     }

        return result;
        
    }
    
    
     void dfs(int row, int col,int [][]grid , boolean [][] visited )
     {

        int[] rows = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int cols[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[row][col] = true;
          

        for (int k = 0; k < 8; k++) 
        {

            int newRow =  row +rows[k]  ;
            int newCol =  col+cols[k];

            if ( isSafe( newRow , newCol , grid , visited)) {
                
                 count++;
                
                dfs( newRow , newCol , grid , visited  );
                
                
               

            }

        }

    }


 boolean isSafe(int newRow, int newCol, int[][] grid, boolean[][] visited )
 {
        if  ( newRow >= 0 && newRow < grid.length
             && newCol >= 0 && newCol < grid[0].length
            && !visited[newRow][newCol] 
            && grid[newRow][newCol] == 1)
            {
            return true;
            }
         
         else{
             return false;
    }
     
 }
 
 
}
