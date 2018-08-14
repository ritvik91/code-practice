package Tree;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 * @author Ritvik
 *
 * rkImp
 */
public class verifyPreorder {

	public static boolean verify(int[] arr) {
		if(arr.length == 0)
			return true;
		
		Stack<Integer> s = new Stack<>();
		
		int root = Integer.MIN_VALUE;
		s.push(arr[0]);
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i] < root)
				return false;
			
			if(arr[i] < s.peek()) {
				s.push(arr[i]);
			}else {
				while(!s.isEmpty() && s.peek() < arr[i]) {
					root = s.pop();
				}
				s.push(arr[i]);
			}
		}
		
		return true;
	}
}
