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

		reader.printMatrix();
		graph.printGraph();
	}
}