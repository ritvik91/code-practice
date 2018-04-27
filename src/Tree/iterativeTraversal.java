package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class iterativeTraversal {

	public void inorder(TreeNode root) {
		
		Stack<TreeNode> s = new Stack<>();
		
		while(root!=null) {
			s.push(root);
			root = root.left;
		}
		
		while(!s.isEmpty()) {
			TreeNode n = s.pop();
			System.out.println(n.val);
			
			if(n.right!=null) {
				TreeNode t = n.right;
				while(t!=null) {
					s.push(t);
					t = t.left;
				}
			}
		}
	}
	
	public void postorder(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		
		TreeNode prev = null;
		
		while(!s.isEmpty()) {
			
			TreeNode curr = s.peek();
			
			if(prev == null || prev.left == curr || prev.right == curr) {
				
				if(curr.left!=null) {
					s.push(curr.left);
				}else if(curr.right!=null) {
					s.push(curr.right);
				}else {
					s.pop();
					res.add(curr.val);
				}
			}else if(curr.left==prev) {
				if(curr.right!=null) {
					s.push(curr.right);
				}else {
					s.pop();
					res.add(curr.val);
				}
			}else if(curr.right==prev){
				s.pop();
				res.add(curr.val);
			}
			prev = curr;
		}
		
	}
	
	public List<List<Integer>> verticalOrder(TreeNode root){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if(root==null)
			return res;
		
		LinkedList<TreeNode> curr = new LinkedList<>();
		LinkedList<Integer> lev = new LinkedList<>();
		
	
		return res;
	}
}
