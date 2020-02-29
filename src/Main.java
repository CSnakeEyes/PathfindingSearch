
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
		Reader reader = new Reader(args[0]);
		// Uncomment below to generate new files
		// FileGenerator fg = new FileGenerator(20, 32);
		// fg.generate(0, 0, 5, 5);
		Graph graph = new Graph(reader.getMap());

		PathfindingSearch pfs = new PathfindingSearch();

		int[][] map = reader.getMap();
		int startIndex = (map[0].length * reader.getStart().x) + reader.getStart().y;
		int goalIndex = (map[0].length * reader.getEnd().x) + reader.getEnd().y;

		long startTime = 0;
		long endTime = 0;

		switch(args[1]) {
			case "IDS":
				startTime = System.nanoTime();
				pfs.IDS(graph.graph, graph.graph[startIndex], reader.getEnd());
				endTime = System.nanoTime();
				break;
			case "BFS":
				startTime = System.nanoTime();
				pfs.BFS(graph.graph, graph.graph[startIndex], graph.graph[goalIndex]);
				endTime = System.nanoTime();
				break;
			case "AS":
				startTime = System.nanoTime();
				pfs.aStar(graph.graph[startIndex], graph.graph, graph.graph[goalIndex]);
				endTime = System.nanoTime();
				break;
			default:
				System.out.println("Not a valid method argument. Try IDS/BFS/AS");
				return;
		}

		double totalTime = (endTime - startTime) / 1e6;

		System.out.println();
		pfs.printStats();
		System.out.println("Total time: " + totalTime + " ms");
	}
}