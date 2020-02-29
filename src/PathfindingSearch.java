
/**
 * @author Miguel Zamudio & Cristian Ayub
 * 
 * Class: CS 4320/5314 
 * Instructor: Dr. Christopher Kiekintveld
 * Assignment: HW3: Search and Pathfinding 
 * Date of last modification: 02/28/2020
 */

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathfindingSearch {
    int totalCost;
    int expandedNodes;
    boolean[] visited;
    PriorityQueue<Node> openNodes;
    boolean goalFound = false;

    /** Constructor **/
    public PathfindingSearch() {
        this.totalCost = 0;
        this.expandedNodes = 0;
    }

    /**
     * Executes Breadth-First Search given a @graph, a @start node, and a @goal node
     * 
     * Returns whether the goal can be reached through the given starting point
     * 
     * @param graph
     * @param start
     * @param goal
     * @return
     */
    public boolean BFS(Node[] graph, Node start, Node goal) {
        long startTime = System.currentTimeMillis(); 
        long endTime = startTime + 180000;              // Checks for time of algorithm

        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[graph.length];
        boolean inGoal = false;
        int pos = start.mapIndex;
        Node startNode = graph[pos];
        this.totalCost = startNode.cost;

        this.visited[pos] = true;
        queue.add(startNode);
        System.out.print(startNode.coordinates.toString() + "->");

        while (!queue.isEmpty()) {
            if (System.currentTimeMillis() > endTime) {
                System.out.println("3 minutes exceeded!");
                return false;
            }

            Node queueNode = queue.remove();
            Node actualNode = graph[queueNode.mapIndex];
            while (actualNode != null && !inGoal) {
                int actualPos = actualNode.mapIndex;
                if (!this.visited[actualPos] && !inGoal) {
                    if (actualPos == goal.mapIndex) {
                        inGoal = true;
                        goalFound = true;
                        return true;
                    }
                    this.visited[actualPos] = true;
                    this.totalCost = this.totalCost + actualNode.cost;
                    // expandedNodes.add(actualNode);
                    expandedNodes++;
                    queue.add(actualNode);
                    System.out.print(actualNode.coordinates.toString() + "->");
                }
                actualNode = actualNode.next;
            }
        }
        return false;
    }

    /**
     * Predicts the successor node given a @start node, a @goal node, and a @graph
     * and returns such predicted successor node.
     * 
     * @param start
     * @param goal
     * @param graph
     * @return
     */
    public Node getSuccessor(Node start, Node goal, Node[] graph) {
        Node successor = start.next;

        if (successor == null || visited[successor.mapIndex]) {
            return successor;
        }

        for (Node t = successor; t != null; t = t.next) {
            t.g = t.cost + totalCost; // Total cost so far to reach this node
            t.h = manhattanDistance(t, goal); // Heuristic distance
            t.f = t.g + t.h; // Predicting value
        }

        for (Node t = successor; t != null; t = t.next) {
            boolean isOpen = openNodes.contains(t);

            if (!isOpen && successor.f > t.f) {
                successor = t;
                System.out.println(successor.toString());
                if (!visited[t.mapIndex]) {
                    openNodes.add(graph[successor.mapIndex]);
                    totalCost += successor.cost;
                }
            }
        }

        return successor;
    }

    /**
     * Executes A* algorithm given a @start node, a @graph, and a @goal node and
     * returns whether the goal has been reached from the starting point
     * 
     * @param start
     * @param graph
     * @param goal
     * @return
     */
    public boolean aStar(Node start, Node[] graph, Node goal) {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 180000;              // Checks for time of algorithm

        visited = new boolean[graph.length];
        openNodes = new PriorityQueue<Node>((Node a, Node b) -> {
            return a.cost < b.cost ? -1 : a.cost > b.cost ? 1 : 0;
        });
        start.g = start.cost;
        totalCost += start.cost;
        openNodes.add(start);

        Node current;

        while (!openNodes.isEmpty()) {
            if (System.currentTimeMillis() > endTime) {
                System.out.println("3 minutes exceeded!");
                return false;
            }

            current = openNodes.poll();

            if (!visited[current.mapIndex]) {
                visited[current.mapIndex] = true;
                if (isGoal(current.coordinates, goal.coordinates)) {
                    return true;
                }
                Node t = getSuccessor(graph[current.mapIndex], goal, graph);
                openNodes.add(graph[t.mapIndex]);
            }
        }
        return false;
    }

    /**
     * Computes the manhattan-distance between node A and B. |x1 - x2| + |y1 - y2|
     * given two nodes @a and @b as arguments and returns their manhattan distance
     * 
     * @param a
     * @param b
     * @return
     */
    public int manhattanDistance(Node a, Node b) {
        return (Math.abs(a.coordinates.x - b.coordinates.x) + (Math.abs(a.coordinates.y - b.coordinates.y)));
    }

    /**
     * Triggers Iterative Deepening Search method given @graph, @start node, @goal
     * point and returns whether the goal is reeacheable from starting point
     * 
     * @param graph
     * @param start
     * @param goal
     * @return
     */
    public boolean IDS(Node[] graph, Node start, Point goal) {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 180000;              // Checks for time of algorithm

        visited = new boolean[graph.length];
        int limit = 50;

        System.out.print("Sequence: ");
        for (int i = 0; i < limit; i++) {
            if (System.currentTimeMillis() > endTime) {
                System.out.println("3 minutes exceeded!");
                return false;
            }
            initialize(visited);
            if (DLS(start, graph, goal, limit)) {
                goalFound = true;
                return true;
            }
        }
        System.out.println("null");
        return false;
    }

    /**
     * Triggers Depth Limited Search algorithm in a recursive manner by passing
     * a @start node, @graph, @goal point, and @limit
     * 
     * @param start
     * @param graph
     * @param goal
     * @param limit // Establishes how deep will the search go within the graph
     * @return
     */

    public boolean DLS(Node start, Node[] graph, Point goal, int limit) {
        return recursiveDLS(start, graph, goal, limit);
    }

    /**
     * Executes Depth Limited Search given a @start node, @graph, @goal point,
     * and @limit and returns whether the goal was reached from starting point
     * 
     * @param node
     * @param graph
     * @param goal
     * @param limit
     * @return
     */
    public boolean recursiveDLS(Node node, Node[] graph, Point goal, int limit) {
        visited[node.mapIndex] = true;

        if (isGoal(node.coordinates, goal)) {
            System.out.print(node.coordinates.toString() + "<-");
            totalCost += node.cost;
            return true;
        } else if (limit <= 0)
            return false;
        else {
            expandedNodes++;
            for (Node t = node.next; t != null; t = t.next) {
                if (!visited[t.mapIndex]) {
                    if (recursiveDLS(graph[t.mapIndex], graph, goal, limit - 1)) {
                        System.out.print(node.coordinates.toString() + "<-");
                        totalCost += node.cost;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * Initializes values for a given boolean @visited array to false
     * 
     * @param visited
     */
    public void initialize(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    /**
     * Returns the total number of visited nodes
     * 
     * @return
     */
    public int totalVisited() {
        int sum = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i])
                sum++;
        }
        return sum;
    }

    /**
     * Checks whether point @a has reached goal @b given such reference points
     * 
     * @param a
     * @param b
     * @return
     */
    public boolean isGoal(Point a, Point b) {
        return a.compare(b);
    }

    /**
     * Prints algorithms statistics
     */
    public void printStats() {
        if (!goalFound) {
            System.out.println("Total cost to goal: " + -1);
            System.out.println("Total expanded nodes: " + null);
        } else {
            System.out.println("Total cost to goal: " + totalCost);
            System.out.println("Total expanded nodes: " + expandedNodes);
        }
        System.out.println("Total nodes in memory: " + totalVisited());
    }
}
