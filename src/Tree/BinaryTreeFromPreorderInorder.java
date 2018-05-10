package Tree;

public class BinaryTreeFromPreorderInorder {

	public TreeNode binaryTreeFromPreIn(int[] inorder, int[] preorder) {
		if(inorder.length!=inorder.length)
			return null;
		
		return helper(inorder,preorder,0,inorder.length-1,0,preorder.length-1);
	}

	private TreeNode helper(int[] inorder, int[] preorder, int inS, int inE, int preS, int preE) {

		if(inS>inE || preS>preE)
			return null;
		
		TreeNode root = new TreeNode(preorder[preS]);
		
		int inRoot = -1;
		
		for(int i=0; i<inorder.length; i++){
	        if(preorder[preS] == inorder[i]){
	        	inRoot=i;
	            break;
	        }
	    }
		
		root.left = helper(inorder, preorder, inS, inRoot-1, preS+1, preS + (inRoot-inS));
		root.right = helper(inorder, preorder, inRoot+1, inE, preS + (inRoot-inS)+1, preE);
		
		return root;
	
	}
}
