package Tree;

public class BSTtoDoublyLikedList {

	TreeNode prev = null;
	TreeNode head = null;
	public void bstToDoublyLinkedList(TreeNode root) {
		
		if(root==null)
			return;
		
		bstToDoublyLinkedList(root.left);
		
		if(prev!=null) {
			prev.right = root;
			root.left = prev;
		}else {
			head = root;
		}
		prev = root;
		
		bstToDoublyLinkedList(root.right);
	}
}
