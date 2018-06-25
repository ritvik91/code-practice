package Misc;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {

	   class TrieNode{
	       Map<Character,TrieNode> child;
	       boolean isLeaf;
	       
	       public TrieNode(){
	           child = new HashMap<Character,TrieNode>();
	           isLeaf = false;
	       }
	   }
	    
	    TrieNode root;
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        root = new TrieNode();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        if(word.length()==0)
	            return;
	        
	        TrieNode p = root;
	        for(int i=0;i<word.length(); i++){
	            char c = word.charAt(i);
	            if(!p.child.containsKey(c)){
	                p.child.put(c,new TrieNode());
	            }
	            p = p.child.get(c);
	        }
	        p.isLeaf = true;
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	     
	        if(word.length()==0)
	            return false;
	        
	        TrieNode p = root;
	        return search(word,0,p);
	    }
	    
	    private boolean search(String word, int i, TrieNode p){
	        
	        if(i >= word.length())
	            return p.isLeaf;
	        
	        for(int k = i; k<word.length(); k++){
	            char c = word.charAt(k);
	            if(p.child.size()==0)
	                return false;
	            if(c!='.'){
	                if(!p.child.containsKey(c))
	                    return false;
	                p = p.child.get(c);
	            }else{
	                for(Map.Entry<Character,TrieNode> e : p.child.entrySet()){
	                    if(search(word,k+1,e.getValue()))
	                        return true;
	                }
	                return false;
	            }
	        }
	        
	        return p.isLeaf;
	    }
	    
	    public static void main(String[] ar) {
	    	WordDictionary wd = new WordDictionary();
	    	wd.addWord("bad");
	    	wd.addWord("mad");
	    	wd.addWord("pad");
	    	wd.addWord("dad");
	    	System.out.println(wd.search("b.."));
	    	
	    	wd.addWord("a");
	    	wd.addWord("a");
	    	System.out.println(wd.search("a."));
	    	System.out.println(wd.search(".a"));
	    	
	    }
	}