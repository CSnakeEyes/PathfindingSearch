
public class Node {
	int x;	// Column
	int y;	// Row
	int cost;
	int coordinate;
	Node next;
	
	public Node(int row, int column) {
		x = column;
		y = row;
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
