package Misc;

public class peakElement {

	 public static int findPeakElement(int[] nums) {
	        if(nums.length==0)
	            return -1;
	        
	        int low = 0;
	        int high = nums.length - 1;
	        
	        while (low < high){
	            int mid = low + (low+high)/2;
	            
	            if (nums[mid] > nums[mid + 1] && (mid==low || nums[mid] > nums[mid-1]))
	                return mid;
	            
	            if(nums[mid] > nums[mid + 1]){
	                high = mid-1;
	            }else{
	                low = mid + 1;
	            }
	        }
	        
	        return low;
	    }
	 
	 public static void main(String[] arg) {
		 int[] arr = {1,2,3,1};
		 
		 System.out.println(findPeakElement(arr));
	 }
	 
}
