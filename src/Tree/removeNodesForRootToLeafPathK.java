package Tree;

//Remove nodes on root to leaf paths of length < K
public class removeNodesForRootToLeafPathK {

	public static TreeNode removeNodesForPathK(TreeNode root, int k) {
		
		if(root==null)
			return root;
		
		remove(root,k);
		return root;
	}
	
	public static boolean remove(TreeNode root, int k) {
		
		if(root.left==null && root.right==null) {
			return k>1?false:true;
		}
		
		boolean left = false;
		boolean right = false;
		if(root.left!=null)
			left = remove(root.left,k-1);
		if(root.right!=null)
			right = remove(root.right,k-1);
		
		if(!left)
			root.left=null;
		if(!right)
			root.right=null;
		
		return left || right;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(7);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(8);
		
		removeNodesForPathK(root, 4);
	}
}
