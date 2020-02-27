public class PathfindingSearch {
    int totalCost;
    int expandedNodes;
    boolean[] visited;

    public PathfindingSearch(){
        
    }

    public boolean IDS(Node[] graph, Node start, Point goal) {
        visited = new boolean[graph.length];
        int limit = 20;

        for(int i = 0; i < limit; i++){
            initialize(visited);
            if(DLS(start, graph, goal, limit))
                return true;
        }
        return false;
    }

    public boolean DLS(Node start, Node[] graph, Point goal, int limit) {
        return recursiveDLS(start, graph, goal, limit);
    }

    public boolean recursiveDLS(Node node, Node[] graph, Point goal, int limit) {
        visited[node.mapIndex] = true;

        if(isGoal(node.coordinates, goal)){
            System.out.print(node.coordinates.toString() + "<-");
            totalCost += node.cost;
            return true;
        } else if (limit <= 0) return false;
        else {
            expandedNodes++;
            for(Node t = node.next; t != null; t = t.next) {
                if(!visited[t.mapIndex]) {
                    if (recursiveDLS(graph[t.mapIndex], graph, goal, limit - 1)) {
                        System.out.print(node.coordinates.toString()+ "<-");
                        totalCost += node.cost;
                        return true;
                    }
                }
            }
            System.out.println();
            return false;
        }
    }

    public void initialize(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    public int totalVisited(){
        int sum = 0;
        for(int i = 0; i < visited.length; i++) {
            if(visited[i])
                sum++;
        }
        return sum;
    }

    public boolean isGoal(Point a, Point b) {
        return a.compare(b);
    }
}
