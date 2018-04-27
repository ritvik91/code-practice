package stack;

import java.util.Stack;

/**
 * Design a Data Structure SpecialStack that supports all the stack operations
 * like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
 * which should return minimum element from the SpecialStack. All these operations of SpecialStack must be O(1). 
 * 
 * http://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 * http://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 * @author Ritvik
 *
 * Q company - goldman sachs
 */
//using O(n) space
public class StackGetMin extends Stack<Integer>{

	Stack<Integer> min = new Stack<Integer>();
	
	public void push(int x){
		
		super.push(x);
		if(min.isEmpty()){
			min.push(x);
		}else{
			int y = min.peek();
			if(x<=y)
				min.push(x);
			/*else				// space optimization
				min.push(y);*/
		}
		
	}
	
	public Integer pop(){
		
		int x = super.pop();
		if(x==min.peek())		//space optimization
			min.pop();
		
		return x;
	}
	
	public int getMin(){
		if(min.isEmpty())
			return -1;
		
		return min.peek();
	}
}

// constant space O(1)
class MinStack{
    
    Stack<Long> min;
    long minEl;
    /** initialize your data structure here. */
    public MinStack() {
        this.min = new Stack<Long>();
    }
    
    public void push(int x) {
        if(min.isEmpty()){
            min.push(Long.valueOf(x));
            minEl = x;
        }else{
            if(x>minEl)
                min.push(Long.valueOf(x));
            else{
                min.push(2*Long.valueOf(x) - minEl);
                minEl = Long.valueOf(x);
            }
            
        }
    }
     
    public void pop() {
       
        if(min.isEmpty())
            return;
        
        long y = min.pop();
        
        if(y<minEl){
            minEl = 2*minEl - y;
        }
        
    }
    
    public int top() {
        long y = min.peek();
        
        if(y<minEl)
            return (int)minEl;
        
        return (int)y;
    }
    
    public int getMin() {
        return (int)minEl;
    }
}
