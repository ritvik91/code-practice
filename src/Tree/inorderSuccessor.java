package Tree;

public class inorderSuccessor {

	public TreeNode inorderSuc(TreeNode root, TreeNode node) {
		
		if(root==null)
			return null;
		
		if(node.right!=null) {
			return findMin(node.right);
		}

		TreeNode succ = null;
		while(root!=null) {
			if(node.val<root.val) {
				succ = root;
				root = root.left;
			}else if(node.val>root.val)
				root = root.right;
			else
				break;
		}
		return succ;
	}
	
	public static TreeNode findMin(TreeNode root) {
		
		if(root.left!=null)
			return findMin(root.left);
		
		return root;
	}
}
