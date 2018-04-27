package Tree;

//Reverse alternate levels of a perfect binary tree - different than spiral order 
//https://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
public class ReverseAlternateLevels {

	public static TreeNode reverseAlt(TreeNode root) {
		if(root==null)
			return root;
		
		
		reverse(root.left,root.right,0);
		return root;
	}

	private static void reverse(TreeNode left, TreeNode right, int lvl) {

		if(left==null || right == null) //since perfect b tree
			return; 
		
		if(lvl%2==0)
			swap(left,right);
		
		reverse(left.left,right.right,lvl+1);
		reverse(left.right,right.left,lvl+1);
	}

	private static void swap(TreeNode left, TreeNode right) {

		int temp = left.val;
		left.val = right.val;
		right.val = temp;
	}
}
