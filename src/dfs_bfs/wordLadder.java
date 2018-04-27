package dfs_bfs;

import java.util.LinkedList;
import java.util.Set;

//q 127
class wordNode{
	String word;
	int step;
	
	public wordNode(String word, int step){
		this.word = word;
		this.step = step;
	}
}
public class wordLadder {

	public static int getWordStep(String startWord, String endWord, Set<String> dict){
		
		LinkedList<wordNode> queue = new LinkedList<wordNode>();
		dict.add(endWord);
		
		queue.offer(new wordNode(startWord, 0));
		while(!queue.isEmpty()){
			wordNode wordN = queue.poll();
			String word = wordN.word;
			
			if(word.equals(endWord))
				return wordN.step;
			
			char[] wordArr = word.toCharArray();
			for(int i=0;i<wordArr.length;i++){
				for(char j='a';j<='z';j++){
					if(wordArr[i]!=j){
						char temp = wordArr[i];
						wordArr[i]=j;
						if(dict.contains(String.valueOf(wordArr))){
							queue.offer(new wordNode(String.valueOf(wordArr),wordN.step+1));
							dict.remove(String.valueOf(wordArr));
						}
						wordArr[i] = temp;
					}
				}
			}
		}
		
		return -1;
		
	}
}
