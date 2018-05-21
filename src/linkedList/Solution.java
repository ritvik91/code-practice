package linkedList;

import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {
		int[] indic = {3,0,1,2};
		System.out.println(longest_cycle(indic));
	}
	
	
	public int max_path(int[][] pyramid) {

		if(pyramid==null || pyramid.length==0)
			return 0;
		
		int m = pyramid.length;
		int n = pyramid[0].length;
		
		int[][] dp = new int[m][n];
		
		for(int i = m-1 ; i>=0;i--)
			for(int j = 0; j<=i ; j++) {
				if(i==m-1) {
					dp[i][j] = pyramid[i][j];
				}else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + pyramid[i][j];
				}
			}
		
		return dp[0][0];
	}
	
	
	
	public static int longest_cycle(int[] indices) {
		if(indices==null || indices.length==0)
			return 0;
		int max = 0;
		boolean[] visited = new boolean[indices.length];
		
		for(int i=0; i<indices.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				int cycle = getCurrentCycle(indices, i,visited);
				max = Math.max(max, cycle);
			}
		}
		
		return max;
	}

	private static int getCurrentCycle(int[] indices, int i, boolean[] visited) {

		int slow = i;
		int fast = i;
		int l = 0;
		
		do {
			slow = indices[slow];
			fast = indices[indices[fast]];
			l++;
			visited[slow] = true;
		}while(slow!=fast);
		
		return l;
	}
	
}
