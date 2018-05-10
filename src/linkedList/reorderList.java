package linkedList;

public class reorderList {

public void reorderList(ListNode head) {
        
        if(head==null || head.next==null || head.next.next== null)
            return;
        
        helper(head,head);
        
    }
    
    public void helper(ListNode head,ListNode tail){
        
        if(tail.next==null)
            return;
        
        helper(head,tail.next);
        
        if(head==tail)
            return;
        
        ListNode next = head.next;
        head.next = tail.next;
        tail.next.next = next;
        tail.next = null;
        
        head = head.next.next;
    }
    
    public void main(String[] ar) {
    	ListNode head = new ListNode(1);
    	
    }
}
