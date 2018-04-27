package Tree;

public class MinDepthOfTree {

	int min = Integer.MAX_VALUE;
	public int getMinDepth(TreeNode root) {
		if(root==null)
			return 0;
		
		 getMin(root,1);
		 return min!=Integer.MAX_VALUE?min:1;
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
