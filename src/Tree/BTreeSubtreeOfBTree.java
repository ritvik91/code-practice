package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Check if a binary tree is subtree of another binary tree 
//rkImp
//https://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/

//The idea is based on the fact that inorder and preorder/postorder uniquely
//identify a binary tree. Tree S is a subtree of T if both inorder and preorder 
//traversals of S arew substrings of inorder and preorder traversals of T respectively.
//as for same inorder, we can have multiple binary trees or bst eg 1,2,3 in inorder
public class BTreeSubtreeOfBTree {

	public boolean isSubTree(TreeNode root, TreeNode sub) {
		if(root==null || sub==null)
			return false;
		
		List<Integer> inR = getInorder(root);
		List<Integer> inS = getInorder(sub);
		
		List<Integer> preR = getPreOrder(root);
		List<Integer> preS = getPreOrder(sub);
		
		return isSubString(inR,inS) && isSubString(preR,preS);
	}

	private boolean isSubString(List<Integer> large, List<Integer> small) {
		
		int i = 0;
		int j = 0;
		
		while(i<large.size() && j<small.size()) {
			if(large.get(i)==small.get(j)) {
				while(large.get(i)==small.get(j) && i<large.size() && j<small.size()) {
					i++;
					j++;
				}
				break;
			}else {
				i++;
			}
		}
		
		if(j==small.size())
			return true;
		
		return false;
	}

	private List<Integer>  getPreOrder(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		if(root==null)
			return res;
		
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()) {
			TreeNode t = s.pop();
			res.add(t.val);
			
			if(t.right!=null) {
				s.push(t.right);
			}
			if(t.left!=null) {
				s.push(t.left);
			}
		}

		return res;
	}

	private List<Integer> getInorder(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		if(root==null)
			return res;
		
		Stack<TreeNode> s = new Stack<>();
		while(root!=null) {
			s.push(root);
			root=root.left;
		}
		
		while(!s.isEmpty()) {
			TreeNode t = s.pop();
			res.add(t.val);
			
			if(t.right!=null) {
				t = t.right;
				while(t!=null) {
					s.push(t);
					t=t.left;
				}
			}else {
				//res.add(Integer.MIN_VALUE);// adding this for null value
			}
		}
		
		return res;
	}
}
