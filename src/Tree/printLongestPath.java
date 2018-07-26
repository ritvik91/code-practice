package Tree;

import java.util.ArrayList;
import java.util.List;

public class printLongestPath {

	public static void longestPath(TreeNode root) {
		if(root==null)
			return;
		
		List<Integer> res = new ArrayList<>();
		
		traversePaths(root,res,new ArrayList<Integer>());
		
		for(Integer i : res)
			System.out.println(i + " ");
	}

	private static void traversePaths(TreeNode root, List<Integer> res, ArrayList<Integer> path) {

		if(root.left == null && root.right == null) {
			path.add(root.val);
			if(res.size() < path.size()) {
				res = new ArrayList<>(path);
			}
			return;
		}
		
		path.add(root.val);
		
		if(root.left != null)
			traversePaths(root.left, res, path);
		
		if(root.right != null)
			traversePaths(root.right, res, path);
	}
	
	public static void main(String[] arg) {
		
	}
}
