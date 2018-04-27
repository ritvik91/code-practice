package dp;

public class maxSumRectangleInMatrix {

	
	public int maxSumRect(int[][] mat) {
		
		if(mat==null)
			return 0;
		
		int m = mat.length;
		int n = mat[0].length;
		
		int l = 0;
		int r = 0;
		int max = Integer.MIN_VALUE;
		int curr = Integer.MIN_VALUE;
		int up = 0;
		int down = 0;
		
		for(l=0;l<n;l++) {
			int[] arr = new int[m];
			for(r=l;r<n;r++) {
				for(int i=0;i<m;i++) {
					arr[i] += mat[i][r]; 
				}
				curr = maxSumSubArray(arr);
				max = Math.max(max, curr);
			}
		}
		return max;
	}
	
	public int maxSumSubArray(int[] arr) {
		int[] dp = new int[arr.length];
		int max = Integer.MIN_VALUE;
		
		dp[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
