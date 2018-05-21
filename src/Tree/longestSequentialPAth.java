package Tree;

public class longestSequentialPAth {
	
	public static void main(String[] arg){
		TreeNode root = new TreeNode(8);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(10);
		root.right.right.right = new TreeNode(11);
		root.left = new TreeNode(7);
		root.left.right = new TreeNode(8);
		
		
		System.out.println(LSP(root));
	}

	public static int LSP(TreeNode node){
		if(node==null)
			return 0;
		
		return Math.max(helper(node.left, 1, 1,node.val),helper(node.right, 1, 1,node.val));
	}
	
	public static int helper(TreeNode node, int pathCount, int max, int target){
		
		if(node==null)
			return max;
		
		if(node.val==target+1){
			pathCount++;
		}else
			pathCount=1;
		
		if(pathCount>max)
			max = pathCount;
		
		return Math.max(helper(node.left, pathCount, max,node.val),helper(node.right, pathCount, max,node.val));
	}
}
