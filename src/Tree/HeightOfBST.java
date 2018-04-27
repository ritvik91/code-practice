package Tree;

import java.util.LinkedList;

public class HeightOfBST {

	//reursive O(n)
	public static int getHeight(TreeNode root){
		if(root==null)
			return 0;
		
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	//Iterative way O(n) -- http://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
	public static int getHeightIterative(TreeNode root){
		
		if(root==null)
			return 0;
		
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		int height = 0;
		q.offer(root);
		
		while(!q.isEmpty()){
			int currNodes = q.size();
			height++;
			
			while(currNodes>0){
				TreeNode par = q.poll();
				currNodes--;
				if(par.left!=null)
					q.offer(par.left);
				if(par.right!=null)
					q.offer(par.right);
			}
		}
		
		return height;
	}
	
}
