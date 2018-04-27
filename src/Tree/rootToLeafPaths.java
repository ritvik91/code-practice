package Tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-paths/description/
public class rootToLeafPaths {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		
		binaryTreePaths(root);
		System.out.println("");
	}

    public static List<String> binaryTreePaths(TreeNode root) {
     
        List<String> res = new ArrayList<String>();
        if(root==null)
            return res;
        
        res.add(Integer.toString(root.val));
        
        if(root.left!=null)
        helper(root.left,res);
        
        res.remove(res.size()-1);
        res.add(Integer.toString(root.val));
        
        if(root.right!=null)
            helper(root.right,res);
        
        return res;
    }
    
    public static void helper(TreeNode root, List<String> res){
        
        if(root.left==null && root.right==null){
            String temp = res.get(res.size()-1);
            String p = res.get(res.size()-1);
            p+="->"+Integer.toString(root.val);
            res.remove(res.size()-1);
            res.add(p);
            res.add(temp);
            return;
            
        }
        
        String path = res.get(res.size()-1);
        path+="->"+Integer.toString(root.val);
        res.remove(res.size()-1);
        res.add(path);
        
        if(root.left!=null){
            helper(root.left,res);
            res.remove(res.size()-1);
            res.add(path);
        }
        
        if(root.right!=null){
            helper(root.right,res);
            res.remove(res.size()-1);
            res.add(path);
        }
    }
}
