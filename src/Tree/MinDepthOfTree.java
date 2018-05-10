package Tree;

public class MinDepthOfTree {

	int min = Integer.MAX_VALUE;
	public int getMinDepth(TreeNode root) {
		if(root==null)
			return 0;
		
		 getMin(root,1);
		 return min!=Integer.MAX_VALUE?min:1;
	}
	
	public static int getMinn(TreeNode root) {
		if(root==null)
			return Integer.MAX_VALUE;
		
		if(root.left==null && root.right==null)
			return 1;
		
		return Math.min(getMinn(root.left), getMinn(root.right)) + 1;
	}
	
	private void getMin(TreeNode root, int depth) {

		if(root.left==null && root.right==null) {
			min = Math.min(min, depth);
			return;
		}
		
		if(root.left!=null)
			getMin(root.left,depth+1);
		
		if(root.right!=null)
			getMin(root.right,depth+1);
		
	}
}
