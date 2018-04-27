package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphNode {

	int val;
	List<GraphNode> adjencyList;
	
	
	public GraphNode(int val){
		this.val = val;
		adjencyList = new ArrayList<GraphNode>();
	}
}
