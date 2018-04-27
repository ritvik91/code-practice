package linkedList;

import java.util.SortedSet;
import java.util.TreeSet;

public class headTailSubtract {
	static Node t;
	public static void main(String[] args) {
		Node head = new Node(1);
		t = head;
		for(int i=2;i<5;i++) {
			t.next = new Node(i);
			t = t.next;
		}
		
		t = head;
		subtract(t);
		
		SortedSet<Integer> s = new TreeSet<>();
	
		}

	public static Node subtract(Node A) {
        
        if(A==null || A.next==null)
            return A;
            
        Node slow = A;
        Node fast = A;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        if(fast!=null){
            slow=slow.next;
        }
            fast = A;
        
        helper(slow);
        
        return A;
        
    }
    
    public static void helper(Node tail ){
        if(tail==null)
            return;
            
        helper(tail.next);
        
        t.val = tail.val-t.val;
        t = t.next;
    }
}
