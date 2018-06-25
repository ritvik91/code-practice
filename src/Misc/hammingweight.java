package Misc;

public class hammingweight {

	 public static int hammingWeight(int n) {
	        
	        int count = 0;
	        
	        while(n>0){
	            count++;
	            n = n & (n-1);
	        }
	        
	        return count;
	    }
	 
	 public static void main(String[] s) {
		 // by default int is signed, that is, max is 2^31 -1. For this question, we are considering int as unsigned
		 // so 2147483648 is allowed rkKnow
	//	hammingWeight(2147483648); 
	 }
}
