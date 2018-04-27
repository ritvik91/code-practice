package Tree;

import java.util.ArrayList;
import java.util.List;
/**
 * rkImp
 * @author Ritvik
 *
 */
public class pathToLeafSum {
	
	public static void main(String[] arg){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.right = new TreeNode(4);
		
		getPaths(root, 12);
	}

	public static List<List<Integer>> getPaths(TreeNode root, int sum){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<>();

		if(root==null)
			return null;
		
		helper(root,res,path,sum);
		return res;
	}

	//rknow // both lists are passed by reference thus values dont change when going from leaf to parent in reverse direction of recursion
	private static void helper(TreeNode root, List<List<Integer>> res,List<Integer> path, int sum) {

		
		path.add(root.val);
		if(root.val==sum &&(root.left==null && root.right==null)){
			List<Integer> temp = new ArrayList<Integer>();// rknow
			temp.addAll(path);							// using a temp list because when path changes, it reflects in res as well as it stores a reference of path as path is an object
			res.add(temp);
		}
		
		if(root.left!=null){
			helper(root.left, res, path,sum-root.val);
			path.remove(path.size()-1); // rknow here when path changes, res would have changed the list pointing to path as well if didn't use temp
		}
		
		if(root.right!=null){
			helper(root.right, res, path, sum-root.val);
			path.remove(path.size()-1);
		}
		
	}
}
