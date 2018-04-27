package Tree;

import java.util.HashMap;
import java.util.Map;

public class verticalTraversal {

	class Node
	{
	    int data;
	    Node left, right;
	   Node(int item)    {
	        data = item;
	        left = right = null;
	    }
	} 
	
	public static void main(String[] arg) {
		
	}
	
	void verticalOrder(Node node) 
    {
        if(node==null)
            return;
            
        Map<Integer,String> map = new HashMap<Integer,String>();
        int[] minMax = {0,0};
        print(node,map,0,minMax);
        
        for(int i=minMax[0];i<=minMax[1];i++) {
			System.out.print(map.get(i));
			System.out.print(" $");
		}
    }
    
    public void print(Node node, Map<Integer,String> map, int order,int[] minMax){
        if(node==null)
        return;
        
        print(node.left,map,order-1,minMax);
        
        if(order>minMax[1])
            minMax[1]=order;
            
        if(order<minMax[0]){
            minMax[0]=order;
        }
        if(map.containsKey(order)){
            String temp = map.get(order);
            temp = String.valueOf(node.data) + " "+ temp;
            map.put(order,temp);
        }else{
            map.put(order,String.valueOf(node.data));
        }
        
        print(node.right,map,order+1,minMax);
    }
}
