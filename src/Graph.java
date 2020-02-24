public class Graph{
  Node[] graph;

  public Graph(int[][] matrix){
    this.graph = new Node[matrix.length*matrix[0].length];
    for(int i=0; i<matrix.length; i++){
      for(int j=0; j<matrix[i].length; j++){
        if(matrix[i][j] !=0){
          graph[(i*matrix[0].length) + j] = new Node(i, j, matrix[i][j]);
          checkAvailableMoves(i, j, matrix);
        }
      }
    }
  }

  private boolean isInRange(int x, int y, int[][] matrix){
    return (x>=0 && x<matrix.length && y>=0 && y<matrix[0].length);
  }

  private void checkAvailableMoves(int x, int y, int[][] matrix){
    Node temp = this.graph[(x*matrix[0].length) + y];
    int tempX = x-1;
    int tempY = y-1;
    for(int i=0; i<2; i++){
      int operation = (i%2 == 0) ? 1 : -1; 
      for(int j=0; j<4; j++){
        tempX = (j<2) ? tempX + operation : tempX;
        tempY = (j>=2) ? tempY + operation : tempY;
        if(isInRange(tempX, tempY, matrix) && matrix[tempX][tempY] != 0){
          temp.next = new Node(tempX, tempY, matrix[tempX][tempY]);
          temp = temp.next;
        }
      }
    }
  }

  public void printGraph(){
    for(int i=0; i<this.graph.length; i++){
      Node temp = this.graph[i];
      while(temp != null){
        System.out.print(temp.cost);
        if(temp.next != null){
          System.out.print(" -> ");
        }
        temp = temp.next;
      }
      System.out.println("");
    }
  }
}