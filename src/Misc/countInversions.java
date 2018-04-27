package Misc;

import java.util.ArrayList;
import java.util.List;

public class countInversions {


  static  class Node{
        int val;
        int count;
        Node left;
        Node right;
        
        public Node(int x, int y){
            this.val = x;
            this.count = y;
        }
    }
    
    static int count = 0;
    public static int countInversion(ArrayList<Integer> A) {
        
        if(A==null|| A.size()<2)
            return 0;
            
            
        Node root = new Node(A.get(0),0);
        for(int i=1;i<A.size();i++){
            root = insertC(A.get(i),root);
        }
        
        return count;
        
    }
    
    public static Node insertC(int a, Node head){
        
       
        Node root = head;
        Node temp = root;
        
        while(temp!=null){
        	root = temp;
            if(a<temp.val){
            	count+=temp.count+1;
                temp = temp.left;
            }else{
            	temp.count++;
                temp = temp.right;
            }
           
        }
        
        if(a<root.val){
            root.left = new Node(a,0);
        }else{
            root.right = new Node(a,0);
        }
        return head;
    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> i = new ArrayList<>();
    	i.add(2);
    	i.add(4);
    	i.add(1);
    	i.add(3);
    	i.add(5);
    	
    	countInversion(i);
    	System.out.println(count);
    }
}
