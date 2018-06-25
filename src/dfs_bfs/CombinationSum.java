package dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates.length==0 )
            return res;
        
        helper(candidates,target,res,new ArrayList<Integer>(),0);
        return res;
    }
    
    public static void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> sol, int index){
        
        if(target==0){
            List<Integer> temp = new ArrayList<Integer>(sol);
            res.add(temp);
            return;
        }
        
        if(target<0 || index >= candidates.length)
            return;
        
        sol.add(candidates[index]);
        helper(candidates,target-candidates[index],res,sol,index);
        sol.remove(sol.size()-1);
        
        helper(candidates,target,res,sol,index+1);
    }
    
    public static void main(String[] args) {
    	int[] candidates = {2,3,5};
    	
    	combinationSum(candidates, 8);
    }
}
