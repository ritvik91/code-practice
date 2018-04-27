package Tree;

import java.util.Stack;

//Check if a given array can represent Preorder Traversal of Binary Search Tree
public class checkArrayGivesPreOrderBST {

	//O(n)
	public boolean isPreOrder(int[] arr) {
		if(arr==null || arr.length==0)
			return false;
		
		Stack<Integer> s = new Stack<>();
		int root = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]<root)
				return false;
			
			while(!s.isEmpty() && s.peek()>arr[i]) {
				root = s.pop();
			}
			
			s.push(arr[i]);
		}
		
		return true;
	}
}
