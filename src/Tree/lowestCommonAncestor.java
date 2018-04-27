package Tree;

public class lowestCommonAncestor {

	public static TreeNode lca(TreeNode root,int n1, int n2) {
		
		if(root==null) {
			return null;
		}
		
		if(root.val==n1 || root.val==n2)
			return root;
		
		TreeNode left = lca(root.left,n1,n2);
		TreeNode right = lca(root.right,n1,n2);
		
		if(left!=null && right!=null)
			return root;
		
		return left!=null?left:right;
		
	}
}
