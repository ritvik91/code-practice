package Misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

public class reorderArrayAsSecondArray {

	public static void reorder(int[] a1, int[] a2) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i = 0; i < a2.length; i++) {
			map.put(a2[i], i);
		}
		
		Integer[] res = new Integer[a1.length];
		for(int i=0;i<a1.length;i++)
			res[i] = a1[i];
		
		Arrays.sort(res,(Integer a, Integer b)->{
			if(map.containsKey(a) && map.containsKey(b)) {
				return map.get(a)-map.get(b);
			}else if (map.containsKey(a)) {
				return -1;
			}else if (map.containsKey(b))
				return 1;
			else
				return a-b;
		});
	}
}
