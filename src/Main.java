
/**
 * @author Miguel Zamudio & Cristian Ayub
 * 
 * Class: CS 4320/5314 
 * Instructor: Dr. Christopher Kiekintveld
 * Assignment: HW3: Search and Pathfinding 
 * Date of last modification: 02/28/2020
 */

import java.io.*;

public class Main {
	/**
	 * Main method receiving arguments as @args
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Reader reader = new Reader("../map1.txt");
		// Uncomment below to generate new files
		// FileGenerator fg = new FileGenerator(20, 32);
		// fg.generate(0, 0, 5, 5);
		Graph graph = new Graph(reader.getMap());

		PathfindingSearch pfs = new PathfindingSearch();

		int[][] map = reader.getMap();
		int startIndex = (map[0].length * reader.getStart().x) + reader.getStart().y;
		int goalIndex = (map[0].length * reader.getStart().x) + reader.getEnd().y;

		long startTime = System.nanoTime();
		// boolean IDS = pfs.IDS(graph.graph, graph.graph[startIndex], reader.getEnd());
		boolean aStar = pfs.aStar(graph.graph[startIndex], graph.graph, graph.graph[goalIndex]);
		// boolean BFS = pfs.BFS(graph.graph, graph.graph[startIndex],
		// graph.graph[goalIndex]);
		long endTime = System.nanoTime();
		double totalTime = (endTime - startTime) / 1e6;

		System.out.println();
		pfs.printStats();
		System.out.println("Total time: " + totalTime + " ms");

		// reader.printMatrix();
		// graph.printGraph();
	}
}