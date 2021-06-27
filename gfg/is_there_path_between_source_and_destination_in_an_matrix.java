package gfg;
public class is_there_path_between_source_and_destination_in_an_matrix{
 
class Solution
{
    private boolean dfs(int sx, int sy, int dx, int dy,boolean[][] vis,int[][] grid)
    {
        //if source and destination indexes are same, we return true.
        if(sx==dx && sy==dy)
            return true;
        
        //marking the cell as visited.    
        vis[sx][sy] = true;
        
        boolean ans = false;
        
        //calling function recursively for adjacent cells.
        if(sx-1>=0 && grid[sx-1][sy]!=0 && !vis[sx-1][sy])
            ans |= dfs(sx-1, sy, dx, dy, vis, grid);
        
        if(sx+1<grid.length && grid[sx+1][sy]!=0 && !vis[sx+1][sy])
            ans |= dfs(sx+1, sy, dx, dy, vis, grid);
            
        if(sy-1>=0 && grid[sx][sy-1]!=0 && !vis[sx][sy-1])
            ans |= dfs(sx, sy-1, dx, dy, vis, grid);
            
        if(sy+1<grid[0].length && grid[sx][sy+1]!=0 && !vis[sx][sy+1])
            ans |= dfs(sx, sy+1, dx, dy, vis, grid);
            
        return ans;
    }
    
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        //using boolean array to mark visited cells.
        boolean vis[][] = new boolean[n][m];
        int sx = -1, sy = -1, dx = -1, dy = -1;
        
        //traversing all the cells of the matrix.
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                //storing the source and destination indexes.
                if(grid[i][j]==1)
                {
                    sx = i;
                    sy = j;
                }
                
                if(grid[i][j]==2)
                {
                    dx = i;
                    dy = j;
                }
            }
        }
        //calling function to check if path exists and returning the result.
        return dfs(sx, sy, dx, dy, vis, grid);
    }
}   
}