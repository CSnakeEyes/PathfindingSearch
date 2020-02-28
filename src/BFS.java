import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class BFS {

  private Point start;
  private Point end;
  private int[][] matrix;
  private Node[] graph;
  private boolean[] visited;
  public int totalCost;
  public List<Node> expandedNodes;

  public BFS(Reader reader, Graph graph) {
    this.start = reader.getStart();
    this.end = reader.getEnd();
    this.matrix = reader.getMap();
    this.graph = graph.graph;
    this.visited = new boolean[this.matrix.length * this.matrix[0].length];
    this.totalCost = 0;
    this.expandedNodes = new ArrayList<Node>();
  }

  public int getPosition(Point coordinates) {
    return coordinates.x * matrix[0].length + coordinates.y;
  }

  public void start() {
    Queue<Node> queue = new LinkedList<>();
    boolean inGoal = false;
    int pos = getPosition(start);
    Node startNode = graph[pos];
    this.totalCost = startNode.cost;

    this.visited[pos] = true;
    queue.add(startNode);

    while (!queue.isEmpty()) {
      Node queueNode = queue.remove();
      Node actualNode = graph[getPosition(queueNode.coordinates)];
      while (actualNode != null && !inGoal) {
        int actualPos = getPosition(actualNode.coordinates);
        if (!this.visited[actualPos] && !inGoal) {
          if (actualPos == getPosition(end)) {
            inGoal = true;
          }
          this.visited[actualPos] = true;
          this.totalCost = this.totalCost + actualNode.cost;
          expandedNodes.add(actualNode);
          queue.add(actualNode);
          System.out.println(actualNode.toString());
        }
        actualNode = actualNode.next;
      }
    }
  }
}