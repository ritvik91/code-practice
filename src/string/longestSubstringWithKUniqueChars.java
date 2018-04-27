package string;

import java.util.HashMap;
import java.util.Map;

//https://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/

//Given a string, find the longest substring that contains 
//only two unique characters. For example, given "abcbbbbcccbdddadacb", 
//the longest substring that contains 2 unique character is "bcbbbbcccb".

public class longestSubstringWithKUniqueChars {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if(s==null || s.length()==0 || k<0)
			return 0;
		
		Map<Character,Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int left = 0;
		
		for(int i=0;i<s.length();i++) {
			
			char c= s.charAt(i);
			
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
			
			if(map.size()>k) {
				max = Math.max(max, i-left);
				
				while(map.size()>k) {
					char lc = s.charAt(left);
					if(map.get(lc)==1) {
						map.remove(lc);
					}else {
						map.put(lc, map.get(lc)-1);
					}
					left++;
				}
			}
			
		}
		max = Math.max(max, s.length()-left);
		
		return max;
		
	}
}
