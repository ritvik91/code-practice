package graphs;
// https://www.programcreek.com/2014/05/leetcode-number-of-connected-components-in-an-undirected-graph-java/

public class numberOfConnectedComponentsInGraph {

	public static int countComponents(int n, int[][] edges) {
		
		int count = n;
		int[] parent = new int[n];
		
		for(int i=0; i<n; i++)
			parent[i] = i;
		
		for(int i=0; i<edges.length; i++) {
			
			int x = edges[i][0];
			int y = edges[i][1];
			
			int xParent = find(x,parent);
			int yParent = find(y,parent);
			
			if(xParent != yParent) {
				count--;
				
				parent[xParent] = yParent;
			}
			
		}
		return count;
	}
	
	public static int find(int i, int[] parent) {
		while(i != parent[i]) {
			parent[i] = parent[parent[i]];
			i = parent[i];
		}
		
		return i;
	}
}
