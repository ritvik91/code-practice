package Tree;

public class closestBSTValue {

	static int min = Integer.MAX_VALUE;
	static int goal;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		closest(root,1);
	}
	
	public static int closest(TreeNode root, int val) {
		if(root==null)
			return -1;
		
		helper(root,val);
		return goal;
	}
	
	public static void helper(TreeNode root, int val) {
		
		if(root==null)
			return;
		
		if(Math.abs(root.val-val)<min) {
			min = Math.abs(root.val-val);
			goal = root.val;
		}
		
		if(val<root.val)
			helper(root.left,val);
		else
			helper(root.right,val);
	}
}
