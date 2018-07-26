package Misc;
//leetcode 642

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class searchAutoComplete {

	class wrap{
		String sentence;
		int hot;
		
		public wrap() {
			sentence = "";
			hot = 0;
		}
		
		public wrap(String s, int times) {
			sentence = s;
			hot = times;
		}
	}
	
	class TrieNode {
		Map<Character,TrieNode> child;
		boolean isLeaf;
		PriorityQueue<wrap> heap;
		
		public TrieNode(){
			child = new HashMap<>();
			isLeaf = false;
			heap = new PriorityQueue<>((wrap w,wrap w2) -> {return w2.hot - w.hot;});
		}
	}
	
	TrieNode root;
	
	public searchAutoComplete(String[] sentences, int[] times) {
		root = new TrieNode();
		for(int i=0; i<sentences.length; i++) {
			insert(sentences[i],times[i]);
		}
	}

	private void insert(String string, int times) {
		
		TrieNode node = root;
		
		for(int i=0; i<string.length(); i++) {
			char c= string.charAt(i);
			if(node.child.get(c)==null) {
				node.child.put(c, new TrieNode());
			}
			node = node.child.get(c);
			node.heap.add(new wrap(string,times));
		}
		
		node.isLeaf = true;
	}
	
	StringBuilder br = new StringBuilder();
	public List<String> input(char c) {
		TrieNode node = root;
		List<String> res = new ArrayList<>();
		
		if(c=='#') {
			insert(br.toString(),1);
			br.setLength(0);
			return new ArrayList<>();
		}
		
		
		
	}
}
