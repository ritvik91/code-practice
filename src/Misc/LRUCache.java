package Misc;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	class Node{
		int key;
		int value;
		
		Node next;
		Node prev;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	Map<Integer,Node> map;
	int capacity;
	Node head;
	Node tail;
	
	public LRUCache() {
		this.map = new HashMap<Integer,Node>();
		this.capacity = 5;
		
	}
	
	public int get(int key) {
		if(map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		
		return -1;
	}
	
	public void remove(Node node) {
		
		if(node.prev!=null) {
			node.prev.next = node.next;
		}else {
			head = head.next;
		}
		
		if(node.next!=null) {
			node.next.prev = node.prev;
		}else {
			tail = tail.prev;
		}
	}
	
	public void setHead(Node node) {
		
		if(head!=null) {
			node.next = head;
			head.prev = node;
		}
		
		head = node;
		
		if(tail==null)
			tail = head;
	}
	
	public void put(int key, int value) {
		
		if(map.containsKey(key)) {
			Node n = map.get(key);
			n.value = value;
			remove(n);
			setHead(n);
			return;
		}
		
		Node node = new Node(key,value);
		map.put(key, node);
		setHead(node);
		
		if(map.size() > capacity) {
			map.remove(tail.key);
			remove(tail);
		}
	}
}
