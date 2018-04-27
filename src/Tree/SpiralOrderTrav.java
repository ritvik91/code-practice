package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SpiralOrderTrav {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public static void main(String[] args){
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		zigzagLevelOrder(root);
	}
	
	    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        List<Integer> lev = new ArrayList<Integer>();
	        List<Integer> lev2 = new ArrayList<Integer>();
	        
	        if(root==null)
	            return res;
	        
	        Stack<TreeNode> s1 = new Stack<>();
	        Stack<TreeNode> s2 = new Stack<>();
	        
	        s1.push(root);
	        while(!s1.isEmpty() || !s2.isEmpty()){
	            while(!s1.isEmpty()){
	                TreeNode node = s1.pop();
	                
	                lev.add(node.val);
	                if(node.left!=null)
	                    s2.push(node.left);
	                if(node.right!=null)
	                    s2.push(node.right);
	                
	            }
	            
	            while(!s2.isEmpty()){
	                TreeNode node = s2.pop();
	                lev2.add(node.val);
	                if(node.right!=null)
	                    s1.push(node.right);
	                if(node.left!=null)
	                    s1.push(node.left);
	            }
	            
	            res.add(lev);
	            lev = new ArrayList<Integer>();
	            if(lev2.size()!=0){
	                res.add(lev2);
	                lev2 = new ArrayList<Integer>();
	            }
	        }
	        return res;
	        
	    }
	
}
