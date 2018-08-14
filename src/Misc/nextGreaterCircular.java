package Misc;

import java.util.Stack;

/**
 * leetcode 503
 * @author Ritvik
 *
 */
public class nextGreaterCircular {

public static int[] nextGreaterElements(int[] nums) {
        
        if(nums.length==0)
            return new int[0];
        
        int[] res = new int[nums.length];
        
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<nums.length; i++){
                while(!s.isEmpty() && nums[s.peek()] < nums[i]){
                    int idx = s.pop();
                    res[idx] = nums[i];
                }
                s.push(i);
                
        }
        
        if(!s.isEmpty()){
            for(int i=0; i<nums.length; i++){
                while(!s.isEmpty() && nums[s.peek()] < nums[i]){
                    int idx = s.pop();
                    res[idx] = nums[i];
                }
            }
        }
        
        while(!s.isEmpty()){
            int idx = s.pop();
            res[idx] = -1;
        }
        
        return res;
    }

public static void main(String[] args) {
	int[] in = {1,2,1};
	
	nextGreaterElements(in);
}
}
