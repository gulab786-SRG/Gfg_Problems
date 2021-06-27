package gfg;

public class floyd_Warshell {
    
class Solution
{
    public void shortest_distance(int[][] matrix)
    {
         int v = matrix.length;
	    
	     for(int i = 0; i < v; i++){
	         
	            for(int j = 0; j < v; j++){
	            
	                if(matrix[i][j] == -1)
	                matrix[i][j] = Integer.MAX_VALUE;
	             }
	       }
	        
	    
	    for(int k = 0; k < v; k++){
	        
	        for(int i = 0; i < v; i++){
	            
	            for(int j = 0; j < v; j++){
	                
	                if(matrix[i][k] ==  Integer.MAX_VALUE || matrix[k][j] ==  Integer.MAX_VALUE)
	                continue;
	                
	                else if(matrix[i][j] > matrix[i][k] + matrix[k][j]){
	                    matrix[i][j] = matrix[i][k] + matrix[k][j];
	                    
	                }
	            }
	        }
	    }
	    for(int i = 0; i < v; i++){
	        
	            for(int j = 0; j < v; j++){
	                
	                if(matrix[i][j] ==  Integer.MAX_VALUE)
	                matrix[i][j] = -1;
	                
	                }
	     }
	        // Code here 
    }
}
}
