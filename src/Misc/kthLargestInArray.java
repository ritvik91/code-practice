package Misc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthLargestInArray {

//quickselect avg - O(n)
    public int findKthLargest(int[] nums, int k) {
        
    	if(nums==null || nums.length==0 || nums.length<k)
            return Integer.MIN_VALUE;
        
        int s=0;
        int e = nums.length-1;
        
        while(true){
            int idx = partition(nums,s,e);
        
            if(idx==Integer.MIN_VALUE)
                return -1;
            
            if(nums.length-k == idx){
                return nums[idx];
            }else if(idx<nums.length-k){
                s = idx+1;
            }else{
                e = idx-1;
            }
                
        }
        
    }
    
    //quickSelect
    public int findKthLargestRec(int[] nums, int k){
    
        if(nums.length==0 || k <=0)
            return -1;
        
        return helper(nums,k,0,nums.length-1);
    }
    
    public int helper(int[] nums, int k, int l, int r){
        if(r<l)
            return -1;
        
        int i = partition2(nums,l,r);
        if(i==nums.length-k)
            return nums[i];
        
        if(i>nums.length-k)
            return helper(nums,k,l,i-1);
        else
            return helper(nums,k,i+1,r);
    }
    
    public int partition2(int[] nums, int l, int r){
        
        int pivot = nums[r];
        int high = r-1;
        
        while(l<=high){
            
            if(nums[l]<pivot)
                l++;
            else{
                swap(nums,l,high);
                high--;
            }
        }
        
        swap(nums,l,r);
        return l;
    }
    
 //   quickselect avg - O(n)
    public int kthSmallest(int[] arr, int l, int r, int k)
    {
    	// If k is smaller than number of elements
    	// in array
    	if (k > 0 && k <= r - l + 1)
    	{
    		// Partition the array around last 
    		// element and get position of pivot 
    		// element in sorted array
    		int pos = partition(arr, l, r);

    		// If position is same as k
    		if (pos-l == k-1)
    			return arr[pos];

    		// If position is more, recur for
    		// left subarray
    		if (pos-l > k-1) 
    			return kthSmallest(arr, l, pos-1, k);

    		// Else recur for right subarray
    		return kthSmallest(arr, pos+1, r, k-pos+l-1);
    	}

    	// If k is more than number of elements
    	// in array
    	return Integer.MAX_VALUE;
    }
    
    public int partition(int[] nums, int s, int e){
        if(s>e)
            return Integer.MIN_VALUE;
        
        int pivot = nums[e];
        int idx = e;
        e--;
        
        while(s<=e){
            if(nums[s]>pivot){
                swap(nums,s,e);
                e--;
            }else{
                s++;
            }
        }
        swap(nums,s,idx);
        return s;
    }
    
    //maxHeap O(n + klog(n))
 public int findKthLargest3(int[] nums, int k){
        
        if(nums==null || nums.length==0 || nums.length<k)
            return Integer.MIN_VALUE;
        
        @SuppressWarnings("unchecked")
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			public int compare(Integer a, Integer b) {
				return b-a;
			}

		});
        
        //build heap
        for(int i=0;i<nums.length;i++){
            maxHeap.add(nums[i]);
        }
        
        int res = -1;
        //getkth
        while(k>0){
            res = maxHeap.remove();
            k--;
        }
        
        return res;
        
    }
    
    public void swap(int[] nums, int s, int e){
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
    
    public static void main(String[] args) {
    	kthLargestInArray kth = new kthLargestInArray();
    	int[] a = {0,5,3,1,2,4};
    	int s = kth.findKthLargestRec(a, 3);
    	System.out.println(s);
    }
}
