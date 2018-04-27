package Tree;

import java.util.LinkedList;

public class BSTSerializeDeserialize {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		
		System.out.println("pre order= "+serializePreOder(root));
		/*System.out.println(serialize(root));
		root = deserialize(serialize(root));
		deserializePreOrder("1,2,#,#,3,4,#,#,5,#,#");*/
		System.out.println(root.val);
		
	}
	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        
        if(root==null)
            return "#";
        
        StringBuffer br = new StringBuffer();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp!=null){
                br.append(String.valueOf(temp.val));
                q.offer(temp.left);
                q.offer(temp.right);
            }else{
                br.append("#");
            }
            br.append(",");
        }
        
        
        return new String(br.toString().substring(0,br.length()-1));
        
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data==null || data.length()==0 || data.equals("#"))
            return null;
     
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
     
     
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
     
        int i=1;
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
     
            if(t==null)
                continue;
     
            if(!arr[i].equals("#")){
                t.left = new TreeNode(Integer.parseInt(arr[i]));    
                queue.offer(t.left);
     
            }else{
                t.left = null;
            }
            i++;
     
            if(!arr[i].equals("#")){
                t.right = new TreeNode(Integer.parseInt(arr[i]));    
                queue.offer(t.right);
     
            }else{
                t.right = null;
            }
            i++;
        }
     
        return root;
}
    
    public static String serializePreOder(TreeNode root) {
    	
    	return help(root,new StringBuilder()).toString();
    }
    
    private static StringBuilder help(TreeNode root, StringBuilder string) {
		
    	if(root==null)
    		return string.append("#,");
    	
    	string.append(root.val + ",");
    	string = help(root.left,string);
    	string = help(root.right,string);
    	
    	return string;
	}
	public static TreeNode deserializePreOrder(String data) {
    	if(data==null || data.equals("#"))
    			return null;
    	
    	String[] arr = data.split(",");
    	int[] i = {0};
    	
    	return helper(arr,i);
    	
    }
	private static TreeNode helper(String[] arr, int[] i) {

		if(arr[i[0]].equals("#"))
			return null;
		
		TreeNode root = new TreeNode(Integer.parseInt(arr[i[0]]));
		i[0]=i[0]+1;
		root.left = helper(arr,i);
		i[0] = i[0]+1;
		root.right = helper(arr,i);
		
		return root;
	
	}
}
