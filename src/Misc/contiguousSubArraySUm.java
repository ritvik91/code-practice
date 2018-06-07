package Misc;

import java.util.HashMap;
import java.util.Map;

public class contiguousSubArraySUm {


    public static boolean checkSubarraySum(int[] nums, int k) {
        
        if(nums.length<2)
            return false;
        
        int[] sums = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        sums[0] = nums[0];
        map.put(sums[0],0);
        map.put(0,-1);
        
        for(int i=1;i<nums.length;i++){
            sums[i] = sums[i-1] + nums[i];
            map.put(sums[i],i);
            
            int nk = k<0 ? -k : k;
            int n = 1;
            while(nk <= sums[i]){
                int compliment = sums[i] - nk;
                
                if(map.containsKey(compliment) && i-map.get(compliment)>=1)
                    return true;
                
                n++;
                nk = n*nk;
                if(nk==0)
                    break;
            }
        }
        
        return false;
        
    }
    
    public static void main(String[] a) {
    	int[] num = {23,0,0,4,1,6};
    	int k = 0;
    	
    	System.out.println(checkSubarraySum(num, k));
    }
}
