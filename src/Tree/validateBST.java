package Tree;

public class validateBST {

	public boolean valid(TreeNode root) {
		if(root==null)
			return true;
		
		return helper(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
	}

	private boolean helper(TreeNode root, int max, int min) {
		
		if(root==null)
			return true;
		
		if(root.val>=max || root.val<=min)
			return false;
		
		return helper(root.left,root.val,min) && helper(root.right,max,root.val);
		
	}
}
