package sort;

import linkedList.ListNode;
//rkKnow
public class mergeSortLinkedList {

	public ListNode sort(ListNode head) {
		if(head==null || head.next==null)
			return head;
		
		int l = getLength(head);
		
		ListNode first = head;
		ListNode second = head;
		ListNode fake = new ListNode(0);
		ListNode prev = fake;
		
		int count = l/2;
		while(count>1) {
			prev = second;
			second = second.next;
			count--;
		}
		
		prev.next = null;
		
		first = sort(first);
		second = sort(second);
		
		return merge(first,second);
	}
	
	public ListNode merge(ListNode first, ListNode second) {
		
		ListNode fake = new ListNode(0);
		ListNode p = fake;
		
		while(first!=null && second!=null) {
			if(first.val < second.val) {
				p.next = first;
				first = first.next;
			}else {
				p.next = second;
				second = second.next;
			}
			p = p.next;
		}
		
		if(first!=null) {
			p.next = first;
		}
		
		if(second!=null)
			p.next = second;
		
		return fake.next;
	}

	private int getLength(ListNode head) {

		int count=0;
		while(head!=null) {
			head = head.next;
			count++;
		}
			
		return count;
	}
}
