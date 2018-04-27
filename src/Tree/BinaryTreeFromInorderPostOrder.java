package Tree;

public class BinaryTreeFromInorderPostOrder {

	public static TreeNode build(int[] inorder, int[] postorder) {
		
		TreeNode root = buildTree(inorder,postorder,0,0,inorder.length-1,postorder.length-1);
		return root;
	}

	private static TreeNode buildTree(int[] inorder, int[] postorder, int instart, int poststart, int inend, int postend) {
		
		if (instart > inend || poststart > postend)
			return null;
		
		int rootValue = postorder[postend];
		TreeNode root = new TreeNode(rootValue);
		
		int k=0;
		for(int i=instart;i<=inend;i++) {
			if(inorder[i]==rootValue) {
				k=i;
				break;
			}
		}
		
		root.left = buildTree(inorder, postorder, instart, poststart, instart+k-1, poststart+k-(instart+1));
		root.right = buildTree(inorder, postorder, k+1, poststart+k-(instart+1)+1, inend, postend-1);
		
		return root;
	}
}
