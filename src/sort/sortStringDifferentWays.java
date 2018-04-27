package sort;

import java.util.Arrays;
import java.util.Comparator;

//sort a list of players based on name, surname, name length and last name letter. 
public class sortStringDifferentWays {
	
	public static void main(String[] args){
		
		String[] players = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet", "John Isner"};
		 
		// Sort players by name using anonymous innerclass
		sortbyFirstNameNormal(players);
		
				
		// Sort players by name using lambda expression
		sortFirstNameLambda(players);
		
	}
	
	public static void sortbyFirstNameNormal(String[] players){
		Arrays.sort(players, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s1.compareTo(s2));
			}
		});
	}
	
	public static void sortFirstNameLambda(String[] players){
		
		Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
		 
		Arrays.sort(players, sortByName);
		// or this
		Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
	}

}
