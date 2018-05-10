package Tree;

public class balancedBinaryTree {

	public static boolean isBalancedTree(TreeNode root) {
		
		if(root==null)
			return false;
		int h = getHeight(root);
		
		return h==-1?false:true;
		
	}
	
	public static int getHeight(TreeNode root) {
		if(root==null)
			return 0;
		
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		
		if(left==-1 || right==-1 || Math.abs(left-right)>1) {
			return -1;
		}
		
		return Math.max(left,right)+1;
		
	}
}
