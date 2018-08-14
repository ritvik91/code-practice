package graphs;
//https://www.programcreek.com/2015/01/leetcode-number-of-islands-ii-java/

public class addLand {

	int[][] matrix = new int[5][5];
	int[][] parent = new int[5][5];
	int count = 0;
	
	public addLand() {
		for(int i =0; i<5; i++)
			for(int j=0; j<5; j++)
				parent[i][j] = -1;
	}
	
	public void addLandOp(int i, int j) {
		if(i<0 || i>=5 || j<0 || j>=5 || matrix[i][j]==1)
			return;
		
		matrix[i][j] = 1;
		parent[i][j] = i*5 + j;
		count++;
		
		int down = find(parent,i-1,j);
		int up = find(parent,i+1,j);
		int left = find(parent,i,j-1);
		int right = find(parent,i,j+1);
		
		if(matrix[i-1][j] == 1 && down != parent[i][j]) {
			parent[i][j] = down;
			count--;
		}
		if(matrix[i+1][j] == 1 && up != parent[i][j]) {
			parent[i][j] = up;
			count--;
		}
		if(matrix[i][j+1] == 1 && right != parent[i][j]) {
			parent[i][j] = right;
			count--;
		}
		if(matrix[i][j-1] == 1 && left != parent[i][j]) {
			parent[i][j] = left;
			count--;
		}
	}

	private int find(int[][] parent, int i, int j) {
		
		if(matrix[i][j] != 1)
			return -1;
		
		while( (i*5 + j) != parent[i][j]) {
			int row = parent[i][j] / 5;
			int col = parent[i][j] % 5;
			
			parent[i][j] = parent[row][col];
			i = row;
			j = col;
		}
		
		return parent[i][j];
	}
}
