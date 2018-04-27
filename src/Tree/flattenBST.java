package Tree;

import java.util.Stack;

public class flattenBST {

	
	//Much more than O(n) and close to O(n2)
	public static TreeNode flatten(TreeNode root){
		if(root==null)
			return root;
		
		TreeNode p = root;
		while(p!=null){
			if(p.left!=null){
				TreeNode temp = p.right;
				p.right = p.left;
				p.left = null;
				TreeNode itr = p;
				while(itr.right!=null){
					itr = itr.right;
				}
				itr.right = temp;
			}
			p=p.right;
		}
		return root;
	}
	
	
	public static void flat(TreeNode root){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
 
        while(p != null || !stack.empty()){
 
            if(p.right != null){
                stack.push(p.right);
            }
 
            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }else if(!stack.empty()){
                TreeNode temp = stack.pop();
                p.right=temp;
            }
 
            p = p.right;
        }
	}
}
