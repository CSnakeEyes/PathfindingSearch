/**
 * @author Miguel Zamudio & Cristian Ayub
 * 
 *         Class: CS 4320/5314 Instructor: Dr. Christopher Kiekintveld
 *         Assignment: HW3: Search and Pathfinding Date of last modification:
 *         02/28/2020
 */

public class Node {
	Point coordinates;
	int mapIndex;
	int cost;
	Node next;
	int g;
	int f;
	int h;
	
	/** Constructor **/
	public Node(int row, int column, int cost, int rowSize) {
		this.coordinates = new Point(row, column);
		this.cost = cost;
		this.mapIndex = (rowSize * coordinates.x) + coordinates.y;
	}

	/** Prints node's coordinates and cost **/
	public String toString(){
		return coordinates.toString() + " Cost: " + cost;
	}
}
