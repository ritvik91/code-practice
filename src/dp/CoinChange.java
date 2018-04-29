package dp;

public class CoinChange {

	public static void main(String[] args) {
		
		int[] coins = {25,10,5,1};
		int amount  = 100;
		
		int minCount = coinChange(coins,amount);
	}


    public static int coinChange(int[] coins, int amount) {
        if(coins.length==0 || amount<0)
            return -1;
        
        if(amount==0)
            return 0;
        
        
        int dp[] = new int[amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0]=0;
        
        for(int i=1;i<dp.length;i++)
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
            }
            
        if(dp[amount]==Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }
}
