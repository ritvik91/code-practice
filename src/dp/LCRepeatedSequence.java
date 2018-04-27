package dp;

/**
 * https://www.geeksforgeeks.org/longest-repeated-subsequence/
 * @author Ritvik
 *
 */
public class LCRepeatedSequence {

	public static int lcr(String s) {
		return lcrs(s,s);
	}

	private static int lcrs(String s, String d) {

		if(s==null || s.length()==0)
			return 0;
		
		int[][] dp = new int[s.length()+1][d.length()+1];
		
		for(int i=1;i<dp.length;i++)
			for(int j=1;j<dp.length;j++) {
				if(s.charAt(i-1)==d.charAt(j-1) && i!=j) {
					dp[i][j] = 1+dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		
		
		return dp[s.length()][s.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(lcr("aabb"));
	}
}
