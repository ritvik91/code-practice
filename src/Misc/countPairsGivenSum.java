package Misc;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/count-pairs-with-given-sum/
//rkImp
public class countPairsGivenSum {

	public static int countPairs(int[] arr, int k) {
		
		int count = 0;
		Map<Integer,Integer> map = new HashMap<>();
		
		for(Integer i : arr) {
			if(map.containsKey(k-i))
				count += map.get(k-i);
			map.put(i, map.getOrDefault(i,0) + 1);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 12, 10, 15, -1, 7, 6,5, 4, 2, 1, 1, 1};
		
		System.out.println(countPairs(arr, 11));
	}
}
