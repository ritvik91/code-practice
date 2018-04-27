package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Q 13. Leetcode
 * 
 * Microsoft
 * 
 * @author Ritvik
 *
 */
public class RomanToInt {
	

	  private static Map<Character, Integer> map = new HashMap<>();
	    
		public static void main (String[] args) {
			map.put('i',1);
	        map.put('x',10);
	        map.put('c',100);
	        map.put('m',1000);
	        map.put('v',5);
	        map.put('l',50);
	        map.put('d',500);
	        
	        Scanner s = new Scanner(System.in);
	        int tc= s.nextInt();
	        for(int i=0;i<tc;i++){
	            String num = s.next().toLowerCase();
	            printDecimal(num);
	            
	        }
	        
	        
		}
		
		public static void printDecimal(String num){
			int len  = num.length();
			int prev = 0;
			int currentNumber = 0;
			int decimal = 0;
			for(int i= len-1;i>=0;i--){
				currentNumber = map.get(num.charAt(i));
				if(prev>currentNumber){
					decimal -= currentNumber;
				}else{
					decimal += currentNumber;
				}
				prev = currentNumber;
			}

			System.out.println(decimal);
		}

	/*
	
	

		public static void main (String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = Integer.parseInt(sc.nextLine());
			int decreaseFlag = 0;
			int number=0;
			
			for(int j=n;j>0;j++){
			    String input = sc.nextLine();
			    
			    for(int i = 0; i<input.length();i++){
			        char curr = input.toUpperCase().charAt(i);
			        if(curr=='M'){
			        	if(decreaseFlag!=200){
			        	number+= 1000;
			        	}else{
			        		number+= 1000 - decreaseFlag;
			        	}
			        	decreaseFlag=0;
			        }else if(curr=='D'){
			        	if(decreaseFlag!=200){
			        		number+=500;
			        	}else{
			        	number+= 100 - decreaseFlag;
			        	}
			        	decreaseFlag=0;
			        }else if(curr=='C'){
			        	if(decreaseFlag!=20){
			        		number+=100;
			        		decreaseFlag = 200;
			        	}else{
			        	number+= 100 - decreaseFlag;
			        	decreaseFlag= 0;
			        	}
			        	
			        }else if(curr=='L'){
			        	if(decreaseFlag!=20){
			        		number+=50;
			        	}else{
			        		number+= 50 - decreaseFlag;
			        	}
			        	decreaseFlag= 0;
			        	
			        }else if(curr=='X'){
			        	if(decreaseFlag!=2){
			        		number+= 10;
			        		decreaseFlag =20;
			        	}else{
			        		number+= 10 - decreaseFlag;
			        		decreaseFlag= 0;
			        	}
			        	number+= 10 - decreaseFlag;
			        	decreaseFlag= 20;
			        }else if(curr=='V'){
			        	if(decreaseFlag!=2){
			        		number+=5;
			        	}else{
			        		number+= 5 - decreaseFlag;
			        	}
			        	decreaseFlag= 0;
			        	
			        }else if(curr=='I'){
			        	number+= 1;
			        	decreaseFlag= 2;
			        }
			        
			        
			    }
			    System.out.println(number);
			    number=0;
			}
			
		}

*/}
