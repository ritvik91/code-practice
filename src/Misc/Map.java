package Misc;

import java.util.ArrayList;
import java.util.List;

class HashNode{

	int value;
	int key;
	
	HashNode next;
	
	public HashNode(int key2, int value2) {
		key = key2;
		value = value2;
		next = null;
	}
}
public class Map {

	int capacity;
	int size;
	double loadFactor;
	
	List<HashNode> list;
	
	public Map() {
		list = new ArrayList<>();
		capacity = 10;
		loadFactor = 0.7;
		
		for(int i=0;i<capacity;i++)
			list.add(null);
	}
	
	public int bucketIndex(int key) {
	
		return Integer.valueOf(key).hashCode()%capacity;
	}
	
	public int get(int key) {
	
		int index = bucketIndex(key);
		
		HashNode head = list.get(index);
		
		while(head!=null) {
			if(head.key==key)
				return head.value;
			head = head.next;
		}
		
		return (Integer)null;
	}
	
	public int remove(int key) {
		int index = bucketIndex(key);
		
		HashNode head = list.get(index);
		HashNode prev = null;

		while(head!=null) {
			if(head.key==key) {
				break;
			}
			prev = head;
			head = head.next;
		}
		
		if(head==null)
			return -1;
		
		size--;
		if(prev==null)
			list.set(index, head.next);
		else {
			prev.next = head.next;
		}
		
		return head.value;
	}

	public void put(int key, int value) {
		
		int index = bucketIndex(key);
		
		HashNode head = list.get(index);
		
		// Check if key is already present
        while (head != null)
        {
            if (head.key == key)
            {
                head.value = value;
                return;
            }
            head = head.next;
        }
        
        head = list.get(index);
		HashNode node = new HashNode(key,value);
		node.next = head;
		list.set(index, node);
		size++;
		
		if((1.0*size)/capacity>=loadFactor) {
			
		}
		
	}
}
