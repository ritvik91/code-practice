package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class longestIncreasingSubSeq {

	//O(n2)
	public int lis(int[] num) {
		
		if(num==null || num.length==0)
	        return 0;
		
		int[] dp = new int[num.length];
		Arrays.fill(dp, 1);
		
		for(int i=1;i<num.length;i++)
			for(int j=0;j<i;j++) {
				if(num[j]<num[i]) {
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}
		
		int res = 0;
		
		for(int i=0;i<dp.length;i++) {
			if(res<dp[i])
				res=dp[i];
		}
		return res;
	}
	
	//O(nlogn)
	public int lisBS(int[] num) {
		if(num==null || num.length==0)
			return 0;
		
		List<Integer> list = new ArrayList<>();
		list.add(num[0]);
		
		for(int i=1;i<num.length;i++) {
			if(num[i]>list.get(list.size()-1))
				list.add(num[i]);
			else {
				int p = 0;
				int k = list.size()-1;
				
				while(p<k) {
					int mid = p + (k-p)/2;
					if(num[i]>list.get(mid)) {
						p = mid+1;
					}else {
						k = mid;
					}
				}
				list.set(k, num[i]);
			}
		}
		return list.size();
	}
	
	public static void main(String[] args) {
		int[] i = {1,3,7,11,5}; // 1 3 7 11
		int[] j = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}; //0 2 6 9 11 15
		
		longestIncreasingSubSeq ll = new longestIncreasingSubSeq();
		ll.lisBS(i);
	}
}
