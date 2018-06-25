package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {

	//[aa,aaa,aaaaa]
	//aaaaa
	
	public static int wordBreak(Set<String> dict, String word){
		List<String> res = new ArrayList<>();
		
		if(dict.size()==0 || word.length()==0)
			return 0;
		
		int[] dp = new int[word.length()+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i=0; i<word.length(); i++) {
			for(int j=0; j<=i; j++) {
				if(dp[j]!= Integer.MAX_VALUE) {
					String sub = word.substring(j,i+1);
					if(dict.contains(sub)) {
						dp[i+1] = Math.min(dp[i+1], dp[j]+1);
					}
				}
			}
		}
		
		return dp[word.length()];
	}
	
	public static void main(String[] a) {
		Set<String> dict = new HashSet<>();
		dict.add("jumped");
		dict.add("over");
		dict.add("some");
		dict.add("thing");
		dict.add("something");
		
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaaa");
		
		
		System.out.println(wordBreak(dict, "aaaaa"));
		
	}
}
