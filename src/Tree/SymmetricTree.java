package Tree;

import java.util.LinkedList;

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		LinkedList<Integer> curr = new LinkedList<Integer>();
		LinkedList<Integer> next = new LinkedList<Integer>();
		
		curr = new LinkedList<Integer>(next);
		
		System.out.println(isSymmetric(root));
	}
	
	public static boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		
		return isSym(root.left,root.right);
	}

	public static boolean isSymRecursion(TreeNode root) {
		
		return true;
	}

    
    public static boolean isSym(TreeNode left, TreeNode right){
        LinkedList<TreeNode> qLeft = new LinkedList<TreeNode>();
        LinkedList<TreeNode> qRight = new LinkedList<TreeNode>();
        
        if(left!=null)
            qLeft.offer(left);
        if(right!=null)
            qRight.offer(right);
        
        while(!qLeft.isEmpty() && !qRight.isEmpty()){
            TreeNode l = qLeft.poll();
            TreeNode r = qRight.poll();
            
            if(l.val!=r.val)
                return false;
            
            if(l.left!=null && r.right!=null){
                qLeft.offer(l.left);
                qRight.offer(r.right);
            }else if(!(l.left==null && r.right==null)){
                return false;
            }
            
            if(l.right!=null && r.left!=null){
                qLeft.offer(l.right);
                qRight.offer(r.left);
            }else if(!(r.left==null && l.right==null)){
                return false;
            }
        }
        
        if(!qLeft.isEmpty() || !qRight.isEmpty())
            return false;
        
        return true;
    } 
}
