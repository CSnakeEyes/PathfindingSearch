public class Point{
  int x;  // Row
  int y;  // Column

  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }

  public boolean compare(Point point){
    return (this.x == point.x && this.y == point.y);
  }

  public String toString(){
    return "(" + this.x + ", " + this.y + ")";
  }
}