package string;
/**
 * Efficiently check if a string has
 * duplicates without using any additional data structure
 * Times - O(n)
 * @author Ritvik
 *
 */
//VOD,Vodafone,10@GOOG,Google,15@MSFT,Microsoft,12:VOD,Vodafone,16,2@GOOG,Google,10,5@MSFT,Microsoft,25,6
public class UniqueStringWithoutSpace {

	boolean isUniqueString(){
		String input = "abcd";
		
		int checker = 0;
		
		for(int i =0;i<input.length();i++){
			
			int val = input.charAt(i)-'a';
			int valBin = Integer.parseInt(Integer.toBinaryString(1<<val),2);
			if((checker & valBin)>0){
				return false;
			}
			checker = (1<<val);
		}
	return true;
	}
	
	public static void main(String[] args){
		
		UniqueStringWithoutSpace sp = new UniqueStringWithoutSpace();
		System.out.println(sp.isUniqueString());
	}
}
