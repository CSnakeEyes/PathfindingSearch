/**
 * @author Miguel Zamudio & Cristian Ayub
 * 
 * Class: CS 4320/5314 
 * Instructor: Dr. Christopher Kiekintveld
 * Assignment: HW3: Search and Pathfinding 
 * Date of last modification: 02/28/2020
 */

public class Graph{
  Node[] graph;

  /** Constructor **/
  public Graph(int[][] matrix){
    this.graph = new Node[matrix.length * matrix[0].length];
    for(int i=0; i<matrix.length; i++){
      for(int j=0; j<matrix[i].length; j++){
        if(matrix[i][j] !=0){
          graph[(i*matrix[0].length) + j] = initialize(i, j, matrix[i][j], matrix[0].length);
          checkAvailableMoves(i, j, matrix);
        }
      }
    }
  }

  /**
   * Initializes a given node
   * 
   * Fills such node with the following data: 
   * 
   * @param row
   * @param column
   * @param cost
   * @param mapIndex
   * @return         // Reference to such node
   */
  private Node initialize(int row, int column, int cost, int mapIndex) {
    return new Node(row, column, cost, mapIndex);
  }

  /**
   * 
   * @param x
   * @param y
   * @param matrix
   * @return
   */
  private boolean isInRange(int x, int y, int[][] matrix){
    return (x>=0 && x<matrix.length && y>=0 && y<matrix[0].length);
  }

  /**
   * Creates nodes for adjacent connections in map (NEWS) given coordinates @x, @y, and @matrix
   * 
   * @param x
   * @param y
   * @param matrix
   */
  private void checkAvailableMoves(int x, int y, int[][] matrix){
    Node temp = this.graph[(x*matrix[0].length) + y];
    int tempX = x-1;
    int tempY = y-1;
    for(int i=0; i<2; i++){
      int operation = (i%2 == 0) ? 1 : -1; 
      for(int j=0; j<4; j++){
        tempX = (j<2) ? tempX + operation : tempX;
        tempY = (j>=2) ? tempY + operation : tempY;
        if(isInRange(tempX, tempY, matrix) && matrix[tempX][tempY]!=0 && j%2==0){
          temp.next = new Node(tempX, tempY, matrix[tempX][tempY], matrix[0].length);
          temp = temp.next;
        }
      }
    }
  }

  /**
   * Prints graph
   */
  public void printGraph(){
    for(int i=0; i<this.graph.length; i++){
      Node temp = this.graph[i];
      while(temp != null){
        System.out.print(temp.cost);
        if(temp.next != null){
          System.out.print(" -> ");
        }
        temp = temp.next;
      }
      System.out.println("");
    }
  }
}