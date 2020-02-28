/**
 * @author Miguel Zamudio & Cristian Ayub
 * 
 * Class: CS 4320/5314 
 * Instructor: Dr. Christopher Kiekintveld
 * Assignment: HW3: Search and Pathfinding 
 * Date of last modification: 02/28/2020
 */

import java.io.*;
import java.util.Scanner;

public class Reader{
  private Scanner scan;

  private Point start;
  private Point end;
  private int[][] map;

  public Reader(String filename) throws FileNotFoundException {
    File file =  new File(filename);
		scan = new Scanner(file);

    Point matrixDimensions = getValues();
    this.start = getValues();
    this.end = getValues();

    this.map = buildMap(matrixDimensions.x, matrixDimensions.y);

    scan.close();
  }

  private Point getValues(){
    String line = scan.nextLine();
		String[] values = line.split(" ");
    int firstValue = Integer.parseInt(values[0]);
    int secondValue = Integer.parseInt(values[1]);
    return new Point(firstValue, secondValue);
  }

  /**
   * Creates a map of size @rows * @ cols out of the matrix of the given file 
   *
   * @param rows
   * @param cols
   */
  private int[][] buildMap(int rows, int cols){
    int[][] matrix = new int [rows][cols];
    for(int i=0; i<rows; i++){
      String line = scan.nextLine();
		  String[] values = line.split(" ");
      for(int j=0; j<cols; j++){
        matrix[i][j] = Integer.parseInt(values[j]);
      }
    }
    return matrix;
  }

  /**
   * Prints a given matrix on the console
   */
  public void printMatrix() {
    for (int i = 0; i < this.map.length; i++) {
      // Go through rows
      for (int j = 0; j < this.map[i].length; j++) {
        // Go through columns
        if (j == this.map[i].length - 1) {
          System.out.println(this.map[i][j]);
        } else {
          System.out.print(this.map[i][j] + " ");
        }
      }
    }
  }

  /** Getters **/

  public Point getStart(){
    return this.start;
  }

  public Point getEnd(){
    return this.end;
  }

  public int[][] getMap() {
    return this.map;
  }
}