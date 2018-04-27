package string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-ladder/description/
public class wordLadder {


    class WordNode{
        String word;
        int numSteps;
        
        public WordNode(String w, int c){
            this.word = w;
            this.numSteps = c;
        }
    }
    
    //BFS solution that takes O(b^d), b is branch and d is depth
    public int ladderLength(String beginWord, String endWord, List<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
 
        if(!wordDict.contains(endWord))
            return 0;
        //wordDict.add(endWord);
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
 
            if(word.equals(endWord)){
                return top.numSteps;
            }
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
 
        return 0;
    }
    
    //bi-directional bfs O(b^(d/2) + b^(d/2))
    //rknow rImpk
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

    	Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

    	int len = 1;
    	int strLen = beginWord.length();
    	HashSet<String> visited = new HashSet<String>();
    	
    	beginSet.add(beginWord);
    	endSet.add(endWord);
    	while (!beginSet.isEmpty() && !endSet.isEmpty()) {
    		if (beginSet.size() > endSet.size()) {
    			Set<String> set = beginSet;
    			beginSet = endSet;
    			endSet = set;
    		}

    		Set<String> temp = new HashSet<String>();
    		for (String word : beginSet) {
    			char[] chs = word.toCharArray();

    			for (int i = 0; i < chs.length; i++) {
    				for (char c = 'a'; c <= 'z'; c++) {
    					char old = chs[i];
    					chs[i] = c;
    					String target = String.valueOf(chs);

    					if (endSet.contains(target)) {
    						return len + 1;
    					}

    					if (!visited.contains(target) && wordList.contains(target)) {
    						temp.add(target);
    						visited.add(target);
    					}
    					chs[i] = old;
    				}
    			}
    		}

    		beginSet = temp;
    		len++;
    	}
    	
    	return 0;
    }
}
