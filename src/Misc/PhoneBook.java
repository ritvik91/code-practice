package Misc;

import java.util.HashMap;
import java.util.*;

class TrieNode{
	Map<Character,TrieNode> child = new HashMap<>();
	boolean isLast;
	
	public TrieNode() {
		for(char c = 'a';c<='z';c++) {
			child.put(c,null);
		}
		isLast = false;
	}
}

class Trie{
	TrieNode root;
	
	public void insert(String s) {
		int len = s.length();
		TrieNode p = root;
		for(int i=0;i<len;i++) {
			TrieNode next = p.child.get(s.charAt(i));
			
			if(next==null) {
				next = new TrieNode();
				p.child.put(s.charAt(i), next);
			}
			
			p = next;
		}
		p.isLast = true;
	}
	
	public void searchSuggestion(String pre, TrieNode curr) {
		
		if(curr==null)
			{
				System.out.println( "No suggestion");
				return;
			}
		
		if(curr.isLast) {
			System.out.println(pre);
			return;
		}
		for(char c = 'a';c<='z';c++) {
			TrieNode next = curr.child.get(c);
			
			if(next!=null) {
				searchSuggestion(pre+c, next);
			}
		}
		
	}
}
public class PhoneBook {

	Trie trie = new Trie();
	
	
}
