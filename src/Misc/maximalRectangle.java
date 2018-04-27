package Misc;

import java.util.Stack;

//Given a 2D binary matrix filled with 0's and 1's, 
//find the largest rectangle containing only 1's and return its area.
// leetcode q85

public class maximalRectangle {

	 public int maximalRectangle(char[][] matrix) {
	        
	        if(matrix==null || matrix.length==0)
	            return 0;
	        
	        int max = Integer.MIN_VALUE;
	        int m = matrix.length;
	        int n= matrix[0].length;
	        
	        int[][] histo = new int[m][n];
	        
	        for(int i=0;i<m;i++) {
	        	for(int j=0;j<n;j++) {
	        		if(matrix[i][j]=='1') {
	        			histo[i][j] = i==0?1:histo[i-1][j]+1;
	        		}else {
	        			histo[i][j] = 0;
	        		}
	        	}
	        	max = Math.max(max, getMaxAreaUnderHistogram(histo[i]));
	        }
	        return max;
	    }

	private int getMaxAreaUnderHistogram(int[] cs) {
		
		if(cs==null || cs.length==0)
			return 0;
		
		Stack<Integer> s = new Stack<>(); 
		int max = Integer.MIN_VALUE;
		
		int i = 0;
		while(i<cs.length){
			if(s.isEmpty() || cs[i]>cs[s.peek()]) {
				s.push(i);
				i++;
			}else {
				int bar = s.pop();
				int left = s.isEmpty()?-1:s.peek();
				int area = cs[bar]*(i-left-1);
				max = Math.max(max, area);
			}
		}
		
		while(!s.isEmpty()) {
			int bar = s.pop();
			int left = s.isEmpty()?-1:s.peek();
			int area = Character.getNumericValue(cs[bar])*(i-left-1);
			max = Math.max(max, area);
		}
		
		return max;
	}
}
