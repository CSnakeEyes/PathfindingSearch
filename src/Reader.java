import java.io.*;
import java.util.Scanner;

public class Reader{
  private Scanner scan;

  private Point start;
  private Point end;
  private int[][] matrix;

  public Reader(String filename) throws FileNotFoundException {
    File file =  new File(filename);
		scan = new Scanner(file);

    Point matrixDimensions = getValues();
    this.start = getValues();
    this.end = getValues();

    this.matrix = buildMatrix(matrixDimensions.x, matrixDimensions.y);

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
	 * Given he rows and columns of a matrix, it scan the values of a matrix
   * of the given file 
   *
   * @param rows
	 * @param cols
	 */
  private int[][] buildMatrix(int rows, int cols){
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

  public Point getStart(){
    return this.start;
  }

  public Point getEnd(){
    return this.end;
  }

  public int[][] getMatrix() {
    return this.matrix;
  }
}