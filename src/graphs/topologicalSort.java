package graphs;

import java.util.Stack;

// https://www.geeksforgeeks.org/topological-sorting/
// O(V+E)
public class topologicalSort {

	public Stack<Integer> topo(Graph g) {
		Stack<Integer>  res = new Stack<>();
		
		boolean[] visited = new boolean[g.V];
		
		for(int i=0;i<g.V;i++) {
			if(!visited[i]) {
				helper(g,res,i,visited);
			}
		}
		
		return res;
	}

	private void helper(Graph g, Stack<Integer>  res, int i, boolean[] visited) {

		visited[i] = true;
		
		for(Integer u : g.adjency[i]) {
			if(!visited[u]) {
				helper(g, res, u, visited);
			}
		}
		
		res.push(i);
	}
}
