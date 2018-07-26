package Misc;

import java.util.HashMap;
import java.util.Map;

//http://buttercola.blogspot.com/2016/06/leetcode-325-maximum-size-subarray-sum.html

//Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
// If there isn't one, return 0 instead.

public class maxSubarray {

	public static int maxSubArray(int[] arr, int k) {
		if(arr.length == 0)
			return 0;
		
		int[] dp = new int[arr.length];
		int max = 0;
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer> ();
		
		map.put(0, -1);
		dp[0] = arr[0];
		map.put(dp[0], 0);
		
		for(int i=1; i<arr.length; i++) {
			
			dp[i] = dp[i-1] + arr[i];
			
			if(map.containsKey(dp[i] - k)) {
				max = Math.max(max, i - map.get(dp[i]-k));
			}
			
			if(!map.containsKey(dp[i])) {
				map.put(dp[i], i);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {-2, -1, 2, 1};
		
		System.out.println(maxSubArray(arr, 1));
	}
}
