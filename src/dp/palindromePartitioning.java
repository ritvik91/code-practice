package dp;

import java.util.ArrayList;
import java.util.List;

//rkImp
public class palindromePartitioning {


	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		
		if(s==null || s.length()==0)
			return res;
		
		boolean[][] dp = new boolean[s.length()][s.length()];
		
		for(int i=0;i<s.length();i++)
			for(int j=0;j<=i;j++) {
				if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1])) {
					dp[j][i] = true;
				}else
					dp[j][i] = false;
			}
		
		helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }
	
	//rknow rkknow
	private static void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
	
	public static void main(String[] args) {
		String s = "aabaa";
		partition(s);
	}
}
