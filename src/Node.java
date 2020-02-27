
public class Node {
	Point coordinates;
	int mapIndex;
	int cost;
	Node next;
	
	public Node(int row, int column, int cost, int rowSize) {
		this.coordinates = new Point(row, column);
		this.cost = cost;
		this.mapIndex = (rowSize * coordinates.x) + coordinates.y;
	}

	public String toString(){
		return coordinates.toString() + " Cost: " + cost;
	}
	
	// public boolean isGoal(int goalRow, int goalCol) {
	// 	if(x == goalCol && y == goalRow)
	// 		return true;
	// 	return false;
	// }
}
