package gfg;

public class flood_fill_algorithm {
    
class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int old =image[sr][sc];
        change(image,sr,sc,newColor,old);
        
        return image;
    }
    void change(int [][] image , int x,int y, int newcolor,int old )
    {
        if(x<0||x>=image.length||y<0||y>=image[0].length||image[x][y]!=old)
        return ;
        
        if(image[x][y]==newcolor)
        return ;
        image[x][y]=newcolor;
     change(image, x+1, y, newcolor, old);
    change(image, x-1, y, newcolor, old);
    change(image, x, y+1, newcolor, old);
    change(image, x, y-1, newcolor, old);
        
        
    }
}
}
