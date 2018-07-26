package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(candidates.length==0 )
	            return res;
	        
	        List<List<Integer>>[][] dp = new ArrayList[target+1][candidates.length+1];
	        Arrays.sort(candidates);
	        
	        for(int i=0 ; i<= target; i++)
	            for(int j=0; j<=candidates.length; j++){
	                
	                if(i==0 || j==0){
	                    if(dp[i][j]==null){
	                        dp[i][j] = new ArrayList<List<Integer>>();
	                        dp[i][j].add(new ArrayList<Integer>());
	                    }
	                }else{
	                    if(dp[i][j]==null)
	                        dp[i][j] = new ArrayList<List<Integer>>();
	                     dp[i][j].addAll(dp[i][j-1]);
	                    if(i-candidates[j-1] >= 0){
	                        for(List<Integer> l : dp[i-candidates[j-1]][j]){
	                            List<Integer> newList = new ArrayList<>(l);
	                            newList.add(candidates[j-1]);
	                            dp[i][j].add(newList);
	                        }
	                    }
	                }
	            }
	        
	        return dp[target][candidates.length];
	        
	    }
	 
	 public static void main(String[] ar) {
		 int[] candidates = {2,3,6,7};
		 int target = 7;
		 
		 combinationSum(candidates, target);
	 }
}
