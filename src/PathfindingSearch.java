import java.io.*;
import java.util.Scanner;


public class PathfindingSearch {

	/**
	 * Builds a matrix of size @rows * @columns
	 * 
	 * @param rows
	 * @param columns
	 * @return a matrix with random values ranging from 0 to 5
	 */
	public static int[][] buildMatrix(int rows, int columns) {
		int min = 0;
		int max = 5;
		
		int[][] matrix = new int[rows][columns];
		
		for(int i = 0; i < rows; i++) {
		// Go through all rows
			for(int j = 0; j < columns; j++) {
			// Go through all columns
				int rand = (int) ((Math.random() * ((max - min) + 1)) + min);
				matrix[i][j] = rand;
			}
		}
		return matrix;
	}
	
	/**
	 * Generates a file containing:
	 * - First line: Matrix size (rows,columns)
	 * - Second line: @startingRow and @startingCol
	 * - Third line: @goalRow and @goalCol
	 * - Fourth line: @map
	 * 
	 * @param startingRow
	 * @param startingCol
	 * @param goalRow
	 * @param goalCol
	 * @param map
	 */
	public static void fileGenerator(int startingRow, int startingCol, int goalRow, int goalCol, int[][] map) {
		File file = new File("map1.txt");
		FileWriter fr = null;
		try {
			fr = new FileWriter(file);
			fr.write(map.length + " ");
			fr.write(map[0].length + "\n");
			fr.write(startingRow + " ");
			fr.write(startingCol + "\n");
			fr.write(goalRow + " ");
			fr.write(goalCol + "\n");
			
			for(int i = 0; i < map.length; i++) {
			// Go through rows
				for(int j = 0; j < map[i].length; j++) {
				// Go through columns
					if (j == map[i].length - 1) {
						fr.write(map[i][j] + "\n");
					} else {
						fr.write(map[i][j] + " ");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Prints a given matrix on the console
	 * 
	 * @param m
	 */
	public static void printMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			// Go through rows
				for(int j = 0; j < m[i].length; j++) {
				// Go through columns
					if (j == m[i].length - 1) {
						System.out.println(m[i][j]);
					} else {
						System.out.print(m[i][j] + " ");
					}
				}
			}
	}
	
	/**
	 * Main method receiving arguments as @args
	 * 
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		int sizeRow = 0;
		int sizeCol = 0;
		int startingRow = 0;
		int startingCol = 0;
		int goalRow = 0;
		int goalCol = 0;
		int[][] map = null;
		
		// FIXME!!
		int[][] m = buildMatrix(5,8);
		printMatrix(m);
		
		// FIXME!!
		fileGenerator(0,0,5,5,m);
		System.out.println("Success!");
		
		File file =  new File("map1.txt");
		Scanner scan = new Scanner(file);
		int count = 0;
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] singleValues = line.split(" ");
			switch(count) {
			case 0: 
				// Stores map size
				sizeRow =  Integer.parseInt(singleValues[0]);
				sizeCol =  Integer.parseInt(singleValues[1]);
				map = new int[sizeRow][sizeCol];
				break;
			case 1:
				// Stores starting point
				startingRow =  Integer.parseInt(singleValues[0]);
				startingCol =  Integer.parseInt(singleValues[1]);
				break;
			case 2:
				// Stores goal point
				goalRow =  Integer.parseInt(singleValues[0]);
				goalCol =  Integer.parseInt(singleValues[1]);
				break;
			default:
				// Stores map from file
				int index = count - 3;
				
				for(int i = 0; i < map[index].length; i++) {
					map[index][i] = Integer.parseInt(singleValues[i]);
				}
				
				break;
			}
			
			count++;
		}
		
		// FIXME!!
		printMatrix(map);
		System.out.print("Success!");
	}
}
