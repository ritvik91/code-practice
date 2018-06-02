package linkedList;

import Tree.TreeNode;
/**
 * LeetCode
 * 109. Convert Sorted List to Binary Search Tree
 * @author Ritvik
 *
 */
public class TreeFromList {

//rknow rkImp
	
	static ListNode h;
    public static TreeNode sortedListToBST(ListNode head) {
        
        if(head==null)
            return null;
        
        h = head;
        int l = getLength(head);
        TreeNode root = helper2(0,l-1);
       
        return root;
        
//        return helper(head);
    }
    
    public static TreeNode helper2(int s, int e) {
    	if(s>e)
    		return null;
    	
    	int m = s + (e-s)/2;
    	TreeNode left = helper2(s,m-1);
    	TreeNode root = new TreeNode(h.val);
    	h = h.next;
    	TreeNode right = helper2(m+1,e);
    	
    	root.left = left;
    	root.right = right;
    	
    	return root;
    }
    
    public static TreeNode helper(ListNode head){
        
        if(head==null)
            return null;
        
        ListNode slow=head;
        ListNode fast = head;
        ListNode prev = null;
        
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            prev = slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        
        ListNode  second = slow.next;
        ListNode first = head;
        if(slow==fast && slow.next==null){
            return root;
        }else if(prev==null){
            first = null;
        }else{
            prev.next = null;
        }
        
        root.left = helper(first);
        root.right = helper(second);
        
        return root;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(-10);
    	head.next = new ListNode(-3);
    	head.next.next = new ListNode(0);
    	head.next.next.next = new ListNode(5);
    	head.next.next.next.next = new ListNode(9);
    	head.next.next.next.next.next = new ListNode(10);
    	head.next.next.next.next.next.next = new ListNode(11);
    	
    	sortedListToBST(head);
    }
    
    public static int getLength(ListNode h) {
    	ListNode p = h;
    	int count = 0;
    	
    	while(p!=null) {
    		p = p.next;
    		count++;
    	}
    	
    	return count;
    }
}
