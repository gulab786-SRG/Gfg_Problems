package gfg;

import java.util.*;
public class searchWord{

    public boolean isWordExist(char[][] board, String word)
    {
        int  m= board.length;
        
        int n=board[0].length;
        
        int length=word.length();
        
        boolean visited[][]=new boolean[m][n];
        
        
        
        for(  int i= 0; i < m;i++)
        {
            for( int j=0; j<n ;j++)
            {
                 if(board[i][j]==word.charAt(0))
                 {
                     String s="";
                     
                     if( dfs( i , j , visited , board , word, s+board[i][j] , 1) )
                     {
                         return true;
                     }
                 }
            }
        }
        return false;
    }
    boolean dfs ( int x, int y , boolean[][] visited ,
                 char [][] board ,String word, String s,int index)
        {
            if(s.length() >word.length())
            return false;
            
            if(s.equals(word))
            return true;
            
            
            visited[x][y]=true;
            
            int dx []={ 0 ,0 ,1 ,-1};
            int dy []={ 1,-1,0,0};
            
            for(int k=0;k<4;k++)
            {
                int r=x+dx[k];
                int c=y+dy[k];
                
                if(r>=0&&c>=0&&r<board.length&&c<board[0].length&&!visited[r][c])
                {
                    if(board[r][c]!=word.charAt(index))
                    continue;
                    
                    else
                    {
                        if(dfs(r,c,visited,board,word,s+board[r][c],index+1))
                        return true;
                    }
                }
            }
            visited[x][y]=false;
            
            return false;
        }         
} 