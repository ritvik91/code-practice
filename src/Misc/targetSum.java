package Misc;

/**
 * Leetcode 494
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
Find out how many ways to assign symbols to make sum of integers equal to target S.
 * @author Ritvik
 *
 */
public class targetSum {

	public static int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0 && S!=0)
            return 0;
        
        if(nums.length==0 && S==0)
            return 1;
        
        int sum = 0;
        for(Integer i : nums)
            sum += i;
        
        return (S+sum)%2 == 0? subsetSum(nums, (S+sum)>>1) : 0;
    }
    
    public static int subsetSum(int[] nums, int s){
        
        int dp[][] = new int[nums.length+1][s+1];
        
        for(int i=0;i<=nums.length;i++)
        	dp[i][0] = 1;
        for(int i = 0 ; i < dp[0].length ; i++)
        	dp[0][i] = 0;
        
        dp[0][0] = 1;
       
        for(int i = 1; i<dp.length;i++)
        	for(int j = 1; j <dp[0].length;j++) {
        		
        		dp[i][j] += dp[i-1][j];
        		if(j >= nums[i-1])
        			dp[i][j] += dp[i-1][j - nums[i-1]];
        	}
        
        return dp[nums.length][s];
    }
    
    public static void main(String[] ar) {
    	int[] nums = {1,1,1,1,1};
    	int s = 3;
    	
    	findTargetSumWays(nums, s);
    }
}
