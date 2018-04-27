package linkedList;

public class addTwoList {

	static int carry = 0;
	public static Node add(Node one, Node two) {
		
		if(one==null || two == null) {
			return one==null?two:one;
		}
		
		int l = getLength(one);
		int l2 = getLength(two);
		
		if(l<l2) {
			one = pad(one,l2-l);
		}else if(l>l2) {
			two = pad(two,l-l2);
		}
		
		Node res = new Node(0);
		res.next = addUtil(one,two);
		
		if(carry>0)
			res.val = carry;
		else
			res = res.next;
		
		return res;
	}
	
	private static Node addUtil(Node one, Node two) {
		if(one==null || two == null) {
			return one==null?two:one;
		}
		
		Node res = new Node(0);
		res.next = addUtil(one.next,two.next);
		res.val += one.val + two.val + carry;
		carry = res.val/10;
		res.val = res.val%10;
		
		return res;
	}

	private static Node pad(Node node, int i) {
		
		while(i>0) {
			Node n = new Node(0);
			n.next = node;
			i--;
			node = n;
		}
		return node;
	}

	private static int getLength(Node node) {
		int count = 0;
		
		while(node!=null) {
			count++;
			node = node.next;
		}
		
		return count;
		
	}
	
	public static void main(String[] arg) {
		Node one = new Node(9);
		Node two = new Node(9);
		
		add(one, two);
	}
}
