package gfg;
 import java.util.*;
public class wordLadder {
    
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Set<String> set= new HashSet<String>();
        
        for( String ele:wordList)
        {
            set.add(ele);
        }
        
        Queue<String> q=new LinkedList<>();
        
        if (startWord.equals(targetWord))
        return 0;
        
        if(!set.contains(targetWord))
        return 0;
        
        int level=0;
        int wordlength=startWord.length();
        
        
        q.add(startWord);
        
        while(!q.isEmpty())
        {
            ++level;
            
            int qSize=q.size();
            
            for(int i=0;i<qSize;i++)
            {
                String tempString=q.peek();
                q.poll();
                
                char word []=tempString.toCharArray();
                
                for(int j=0;j<wordlength;j++)
                {
                    char originalCharacter=word[j];
                    
                    for( char c='a';c<='z';c++)
                    {
                        word[j]=c;
                        
                        
                        if(targetWord.equals(new String(word)))
                        return level+1;
                        
                        if(!set.contains(new String(word)))
                        {
                            continue;
                        }
                        
                        set.remove(new String (word));
                        q.add(new String(word));
                        
                    }
                    word[j]=originalCharacter;
                }

            }
        }
        return 0;
    }
}
}
