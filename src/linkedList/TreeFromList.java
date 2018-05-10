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
    public static TreeNode sortedListToBST(ListNode head) {
        
        if(head==null)
            return null;
        
        return helper(head);
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
    	
    	sortedListToBST(head);
    }
}
