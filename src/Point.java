/**
 * @author Miguel Zamudio & Cristian Ayub
 * 
 * Class: CS 4320/5314 
 * Instructor: Dr. Christopher Kiekintveld
 * Assignment: HW3: Search and Pathfinding 
 * Date of last modification: 02/28/2020
 */

public class Point{
  int x;  // Row
  int y;  // Column

  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }

  /**
   * Compares whether the actual point is equal to another given point
   * 
   * @param point
   * @return
   */
  public boolean compare(Point point){
    return (this.x == point.x && this.y == point.y);
  }

  /**
   * Prints point coordinates
   */
  public String toString(){
    return "(" + this.x + ", " + this.y + ")";
  }
}