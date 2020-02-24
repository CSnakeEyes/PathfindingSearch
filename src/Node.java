
public class Node {
	Point coordinates;
	int cost;
	Node next;
	
	public Node(int row, int column, int cost) {
		this.coordinates = new Point(row, column);
		this.cost = cost;
	}

	public String toString(){
		return coordinates.toString() + " Cost: " + cost;
	}
	
	/*public boolean isGoal(int goalRow, int goalCol) {
		if(x == goalCol && y == goalRow)
			return true;
		return false;
	}
	
	public int getIndex(int rowSize) {
		return (rowSize * y) + x;
	}*/
}
