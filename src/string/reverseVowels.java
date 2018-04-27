package string;

public class reverseVowels {

	
	public static String revVowels(String input){
		
		char[] inputCh = input.toCharArray();
		
		int i=0;
		int j=inputCh.length-1;
		boolean iFlag=false;
		
		while(i<j){
			if(inputCh[i]=='a'||inputCh[i]=='e'||inputCh[i]=='i'||inputCh[i]=='o'||inputCh[i]=='u'){
				iFlag=true;
			}else{
				i++;
			}
			if(inputCh[j]=='a'||inputCh[j]=='e'||inputCh[j]=='i'||inputCh[j]=='o'||inputCh[j]=='u'){
				if(iFlag){
					inputCh = reverse(inputCh,i,j);
					i++;
					j--;
				}
			}else{
				j--;
			}
		}
		
		return inputCh.toString();
	}
	
	public static char[] reverse(char[]s, int f, int l){
		
		char temp = s[f];
		s[f] = s[l];
		s[l]  = temp;
		
		return s;
	}
}
