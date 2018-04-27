package string;

import java.util.HashMap;
import java.util.Map;

//Given a string, find the length of the longest substring without repeating characters.
// leetcode Q3
public class longestUniqueSubstring {


    public static int lengthOfLongestSubstring(String s) {
        
        if(s==null ||s.length()==0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        String longest = "";
        Map<Character,Integer> map = new HashMap<>();
        
        int i=0;
        int j=0;
        
        while(j<s.length()){
            if(!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),j);
                if(max<j-i+1){
                    longest = s.substring(i,j+1);
                    max = j-i+1;
                }
                j++;
            }else{
            	int prev = map.get(s.charAt(j));
            	for(;i<=prev;i++)	// case "tmmzuxt"
            		map.remove(s.charAt(i));
                map.put(s.charAt(j),j);
                j++;
            }
        }
        return max;
    }
    
    //O(n)
    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
    
    public static void main(String[] args) {
    	
    	String s = "tmmzuxt";
    	System.out.println(lengthOfLongestSubstring(s));
    	
    }
}
