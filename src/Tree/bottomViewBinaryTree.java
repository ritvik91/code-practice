package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class bottomViewBinaryTree {

	public static List<Integer> bottomView(TreeNode root){
		
		List<Integer> res = new ArrayList<Integer>();
		if(root==null)
			return res;
		

		Map<Integer,Integer> map = new TreeMap<>();// so that we have sorted result
		LinkedList<TreeNode> q = new LinkedList<>();
		LinkedList<Integer> longitude = new LinkedList<>();
		
		q.offer(root);
		longitude.offer(0);
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			int l = longitude.poll();
			
			map.put(l,curr.val);
			
			if(curr.left!=null) {
				q.offer(curr.left);
				longitude.offer(l-1);
			}
			if(curr.right!=null) {
				q.offer(curr.right);
				longitude.offer(l+1);
			}
			
		}
		
		for(Entry<Integer, Integer> e : map.entrySet()) {
			System.out.println(e.getValue());
			res.add(e.getValue());
		}
		return res;
	}
	
	public static void main(String[] args) {
	
		int[] inO = {5,8,10,3,14,20,22,25};
		int[] postO = {5,10,14,3,8,25,22,20};
		TreeNode root = BinaryTreeFromInorderPostOrder.build(inO, postO);
		
		root=new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		root.right.right = new TreeNode(25);
		
		bottomView(root);
	
	}
	
}
