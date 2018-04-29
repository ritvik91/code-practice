package dp;

class Pair{
    int a;
    int b;
     
    public Pair(int a, int b) {
        this.a = a;
       
    }
}
public class maxLengthChain {

	public static int maxLen(Pair[] pair, int n) {
		int dp[] = new int[n];
		
		dp[0] = 1;
		for(int i=0;i<n;i++)
			dp[i] = 1;
		int max = 0;
		
		for(int i=1;i<n;i++)
			for(int j=0;j<i;j++) {
				if(pair[i].a>=pair[j].b) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					max = Math.max(max, dp[i]);
				}
			}
		return max;
	}
}
