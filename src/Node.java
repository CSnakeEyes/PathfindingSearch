
public class Node {
	int x;	// Column
	int y;	// Row
	int cost;
	Node next;
	
	public Node(int row, int column, int cost) {
		x = column;
		y = row;
		this.cost = cost;
	}
	
	public boolean isGoal(int goalRow, int goalCol) {
		if(x == goalCol && y == goalRow)
			return true;
		return false;
	}
	
	public int getIndex(int rowSize) {
		return (rowSize * y) + x;
	}
}
