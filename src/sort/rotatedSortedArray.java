package sort;
//33. Search in Rotated Sorted Array
public class rotatedSortedArray {

	public static int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        
        int i=0;
        int j = nums.length-1;
        
        while(i<=j){
            int mid = i+((j-i)>>1);
            
            if(nums[mid]==target)
                return mid;
            
            if(nums[mid]>=nums[i]){
                if(nums[mid]>target && target>=nums[i])
                    j = mid-1;
                else
                    i = mid+1;
            }else{
                if(nums[mid]<target && target<=nums[j])
                    i = mid+1;
                else
                    j = mid-1;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] i = {4,5,6,7,0,1,2};
		
		System.out.println(search(i, 0));
	}
}
