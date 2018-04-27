package graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	public int V;
	public List<Integer> adjency[];
	
	public Graph(int v) {
		V = v;
		for(int i=0;i<v;i++)
			adjency[i] = new ArrayList<Integer>();
	}
	
	public void addEdge(int u, int v) {
		adjency[u].add(v);
	}
}
