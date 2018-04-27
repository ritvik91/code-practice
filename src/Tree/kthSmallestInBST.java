package Tree;

import java.util.Stack;

public class kthSmallestInBST {

	//Binary Search
	// we can also have the count of left subtree in each root, thus changing the DS of tree => O(logn)
	 public int kthSmallest(TreeNode root, int k) {
	        int count = countNodes(root.left);
	        if (k <= count) {
	            return kthSmallest(root.left, k);
	        } else if (k > count + 1) {
	            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
	        }
	        
	        return root.val;
	    }
	    
	    public int countNodes(TreeNode n) {
	        if (n == null) return 0;
	        
	        return 1 + countNodes(n.left) + countNodes(n.right);
	    }
	    
	    //InOrder O(n)
	    public int kthSmallestInOrder(TreeNode root, int k) {
	        
	        if(root==null || k<1)
	            return -1;
	        Stack<TreeNode> s = new Stack<TreeNode>();
	        TreeNode q = root;
	        while(q!=null){
	            s.push(q);
	            q=q.left;
	        }
	        
	        while(!s.isEmpty()){
	            TreeNode p = s.pop();
	            k--;
	            if(k==0)
	                return p.val;
	            if(p.right!=null){
	                p=p.right;
	                while(p!=null){
	                    s.push(p);
	                    p=p.left;
	                }
	            }
	        }
	        
	        return -1;
	    }
}
