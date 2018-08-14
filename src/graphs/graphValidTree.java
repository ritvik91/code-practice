package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class graphValidTree {

	public boolean validTree(int n, int[][] edges) {
		if(n <= 1)
			return true;
		
		Map<Integer,ArrayList<Integer>> map = new HashMap<>();
		boolean[] visit = new boolean[n];
		
		for(int i=0; i<edges.length; i++) {
			for(int j=1; j<edges[0].length; j++) {
				ArrayList<Integer> list;
				if(map.containsKey(edges[i][0])) {
					list = map.get(edges[i][0]);
				}else {
					list = new ArrayList<>();
				}
				list.add(edges[i][j]);
				map.put(edges[i][0],list);
			}
		}
		
		if(dfs(map,visit,new boolean[n], 0))
			return false;
		
		/*for(int i=0; i<n; i++) {
			if(!visit[i]) {
				boolean isCycle = dfs(map,visit,new boolean[n], i);
				if(isCycle)
					return false;
			}
		}*/
		
		for(boolean b: visit){
	        if(!b)
	            return false;
	    }
		
		return true;
	}

	private boolean dfs(Map<Integer, ArrayList<Integer>> map, boolean[] visit, boolean[] rec, int idx) {

		if(rec[idx])
			return true;
		
		visit[idx] = true;
		rec[idx] = true;
		
		ArrayList<Integer> list = map.get(idx);
		for(Integer i : list) {
			if (dfs(map,visit,rec, i))
				return true;
		}
		
		rec[idx] = false;
		
		return false;
	}
	
}
