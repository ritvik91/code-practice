package dp;

//https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces
 * @author Ritvik
 *
 */
public class cuttingRod {

	public static int getMaxProfit(int[] price, int n) {
		int dp[] = new int[n+1];
		
		dp[0] = 0;
		
		for(int i=1;i<n+1;i++)
			for(int j=0;j<i;j++) {
				dp[i] = Math.max(dp[i],Math.max(price[i-1], dp[j]+dp[i-j]));
			}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		
		int[] prices = {1,5,8,9,10,17,17,20};
		int n = 8;
		
		System.out.println(getMaxProfit(prices, n));
	}
}
