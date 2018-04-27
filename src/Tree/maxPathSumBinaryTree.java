package Tree;

public class maxPathSumBinaryTree {


    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        if(root==null)
            return 0;
        
        int sum = root.val;
        sum = getSum(root,sum);
        return Math.max(max,sum);
    }
    
    public int getSum(TreeNode root, int sum){
        
        if(root==null)
            return 0;
        
        
        int left = getSum(root.left,sum);
        int right = getSum(root.right,sum);
        
        sum = Math.max(root.val,Math.max(root.val+left,root.val+right));
        max = Math.max(max,Math.max(sum,left+root.val+right)); // for case 1,2,3 in preorder
        return sum;
            
    }
}
