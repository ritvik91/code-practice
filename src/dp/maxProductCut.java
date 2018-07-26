package dp;
/*
 * Given a rope of length n meters, cut the rope in different parts of integer lengths in a way
 *  that maximizes product of lengths of all parts. You must make at least one cut. 
 *  Assume that the length of rope is more than 2 meters.
 *  */

public class maxProductCut {

	public static int maxCuts(int n) {
		
		int[] dp = new int[n+1];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i=1;i<=n; i++) {
			for(int j=1; j<= i/2 ; j++) {
				dp[i] = Math.max(dp[i], j* (i-j));
				dp[i] = Math.max(dp[i], j*dp[i-j]);
			}
		}
		return dp[n];
	}
	
	public static void main(String[] ar) {
		System.out.println(maxCuts(11));
	}
}
