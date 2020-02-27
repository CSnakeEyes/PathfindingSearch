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
		Graph graph = new Graph(reader.getMap());

		PathfindingSearch pfs = new PathfindingSearch();

		int[][] map = reader.getMap();
		int arrayIndex = (map[0].length * reader.getStart().x) + reader.getStart().y;

		long startTime = System.nanoTime();
		boolean IDS = pfs.IDS(graph.graph, graph.graph[arrayIndex], reader.getEnd());
		long endTime = System.nanoTime();
		double totalTime = (endTime - startTime) / 1e6;

		System.out.println(IDS);

		// pfs.traceNode();
		System.out.println();
		System.out.println("Total cost to goal: " + pfs.totalCost);
		System.out.println("Total expanded nodes: " + pfs.expandedNodes);
		System.out.println("Total nodes in memory: " + pfs.totalVisited());
		System.out.println("Total time: " + totalTime + " ms");

		// reader.printMatrix();
		// graph.printGraph();
	}
}