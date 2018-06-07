package linkedList;

import java.util.Stack;

public class reorderList {

	public static void reorderList(ListNode head) {

		if(head==null || head.next==null || head.next.next== null)
			return;

		Stack<ListNode> s = new Stack<>();

		ListNode p = head;
		while(p!=null){
			s.push(p);
			p = p.next;
		}

		p= head;
		int size = s.size();
		size = size/2;
		while(size > 0){
			ListNode tail = s.pop();
			ListNode next = p.next;
			p.next = tail;
			tail.next = next;
			p = p.next.next;
			size--;
		}

		p.next = null;        
	}
    
  
    
    public static void main(String[] ar) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(5);
    	
    	reorderList(head);
    	
    }
}
