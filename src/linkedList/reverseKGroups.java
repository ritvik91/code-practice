package linkedList;

public class reverseKGroups {

	 
    public static ListNode reverseKGroup(ListNode head, int k){
        if(head==null || head.next==null || k<2)
            return head;
        
        ListNode fakeH = new ListNode(0);
        fakeH.next = head;
        
        ListNode pre = fakeH;
        ListNode curr = head;
        
        int i=0;
        while(curr!=null){
            if(i!=0 && i%k==0){
                pre = rev(pre,curr);
            }
            curr=curr.next;    
            i++;
        }
        
        if(i%k==0){
            rev(pre,curr);
        }
        
        return fakeH.next;
        
    }
    public static ListNode rev(ListNode pre, ListNode end){
        ListNode curr = pre.next;
        ListNode h = pre;
        
        while(curr!=end){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        
        ListNode ret = h.next;
        h.next.next = curr;
        h.next = pre;
        return ret;
    }
    
    public static void main(String[] args) {
    	ListNode h = new ListNode(1);
    	h.next = new ListNode(2);
    	
    	reverseKGroup(h, 2);
    }
}
