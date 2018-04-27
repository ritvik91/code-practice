package string;

/**
 * Given a string, that contains special character 
 * together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), 
 * reverse the string in a way that special characters are not affected.
 * @author Ritvik
 *
 */
public class reverseNotSpecialChar {

	public static void main(String[] args){
		
		String input = "a,bc$d";
		
		reverseEff(input);
		
	}
	
	public static void reverseEff(String input){
		
		int first  = 0;
		int last = input.length()-1;

		while(first < last){
			if(!(input.toLowerCase().charAt(first)>='a' && input.toLowerCase().charAt(first)<='z')){
				first++;
			}else if(!(input.toLowerCase().charAt(last)>='a' && input.toLowerCase().charAt(last)<='z')){
				last--;
			}else{
				char temp;
				char[] temparray = input.toCharArray();
				temp = temparray[first];
				temparray[first] = temparray[last];
				temparray[last] = temp;
				input = String.valueOf(temparray);
				first++;
				last--;
			}
		}
		
		System.out.println(input);
	}
	
}
