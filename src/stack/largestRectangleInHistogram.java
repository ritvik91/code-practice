package stack;

import java.util.Stack;

public class largestRectangleInHistogram {

	public static int getLargestRectHisto(int[] arr) {
		
		Stack<Integer> s = new Stack<>();
		int max = Integer.MIN_VALUE;
		
		int i = 0;
		while(i<arr.length) {
			
			if(s.isEmpty() || arr[i]>=arr[s.peek()]) {
				s.push(i);
				i++;
			}else {
				int h = s.pop();
				int l = s.isEmpty()?-1:s.peek();
				int area = arr[h]*(i-l-1);
				max = Math.max(max, area);
			}
		}
		
		while(!s.isEmpty()) {
			int h = s.pop();
			int l = s.isEmpty()?-1:s.peek();
			int area = arr[h]*(i-l-1);
			max = Math.max(max, area);
		}
		return max;
	}
}
