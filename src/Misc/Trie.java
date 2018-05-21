package Misc;

public class Trie {
	
	class TrieNode{
		TrieNode[] children;
		boolean isLeaf;
		
		public TrieNode() {
			children = new TrieNode[26];
			for(int i=0;i<26;i++)
				children[i] = null;
			isLeaf = false;
		}
	}

	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String key) {
		
		TrieNode node = root;
		
		for(int i=0;i<key.length();i++) {
			char c = key.charAt(i);
			if(node.children[c-'a']==null) {
				node.children[c-'a'] = new TrieNode();
			}
			node = node.children[c-'a'];
		}
		node.isLeaf = true;
	}
	
	public boolean prefix(String prefix) {
		
		TrieNode node = root;
		
		for(int i=0;i<prefix.length();i++) {
			char c = prefix.charAt(i);
			
			if(node.children[c-'a']==null)
				return false;
			
			node = node.children[c-'a'];
		}
		return true;
	}
	
	public boolean search(String search) {
		
		TrieNode node = root;
		
		for(int i=0;i<search.length();i++) {
			char c = search.charAt(i);
			
			if(node.children[c-'a']==null)
				return false;
			
			node = node.children[c-'a'];
		}
		if(node.isLeaf)
			return true;
		
		return false;
	}
}
