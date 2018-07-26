package dp;

public class countWaysCoinChange {

	public static int countWays(int[] coins, int n) {
		
		if(coins.length==0 || n==0)
			return 0;
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		
 		for(int i=0; i<coins.length ;i++ ) {
 			for(int j=coins[i]; j<=n ; j++) {
 					dp[j] += dp[j-coins[i]];
 			}
 		}
 		return dp[n];
	}
	// 0 1 2 3 4 5 6 7 8 9 10
	// 0 0 1 1 1 
	
	public static void main(String[] args) {
		int[] co = {2, 5, 3, 6};
		
		System.out.println(countWays(co, 10));
	}
}
