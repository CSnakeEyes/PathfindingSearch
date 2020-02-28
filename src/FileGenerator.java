
/**
 * @author Miguel Zamudio & Cristian Ayub
 * 
 * Class: CS 4320/5314
 * Instructor: Dr. Christopher Kiekintveld
 * Assignment: HW3: Search and Pathfinding
 * Date of last modification: 02/28/2020
 */

import java.io.*;

public class FileGenerator {

    int[][] map;

    /**
     * Builds a matrix of size @rows * @columns
     * 
     * @param rows
     * @param columns
     * @return a matrix with random values ranging from 0 to 5
     */
    public FileGenerator(int rows, int columns) {
        int min = 0;
        int max = 5;

        this.map = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            // Go through all rows
            for (int j = 0; j < columns; j++) {
                // Go through all columns
                int rand = (int) ((Math.random() * ((max - min) + 1)) + min);
                this.map[i][j] = rand;
            }
        }
    }

    /**
     * Generates a file containing: - First line: Matrix size (rows,columns) -
     * Second line: @startingRow and @startingCol - Third line: @goalRow
     * and @goalCol - Fourth line: @map
     * 
     * @param startingRow
     * @param startingCol
     * @param goalRow
     * @param goalCol
     * @param map
     */
    public void generate(int startingRow, int startingCol, int goalRow, int goalCol) {
        File file = new File("map3.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(this.map.length + " ");
            fr.write(this.map[0].length + "\n");
            fr.write(startingRow + " ");
            fr.write(startingCol + "\n");
            fr.write(goalRow + " ");
            fr.write(goalCol + "\n");

            for (int i = 0; i < this.map.length; i++) {
                // Go through rows
                for (int j = 0; j < this.map[i].length; j++) {
                    // Go through columns
                    if (j == this.map[i].length - 1) {
                        fr.write(this.map[i][j] + "\n");
                    } else {
                        fr.write(this.map[i][j] + " ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}