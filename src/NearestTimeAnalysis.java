import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

public class NearestTimeAnalysis {
  public static void main(String[] args) {

    int runFor = 10;

    String filename = args[0];
    In in = new In(filename);

    KdTree kdtree = new KdTree();
    PointSET brute = new PointSET();
    while (!in.isEmpty()) {
      double x = in.readDouble();
      double y = in.readDouble();
      Point2D p = new Point2D(x, y);
      brute.insert(p);
      kdtree.insert(p);
    }

    float bruteAvg = 0, kdTreeAvg = 0;
    for (int i = 0; i < runFor; i++) {

      long startTime = System.nanoTime();
      long endTime = System.nanoTime() - startTime;
      int count = 0;

      while ((float) endTime / 1000000000 < 1) {
        Point2D query = new Point2D(StdRandom.uniform(0.0, 1.0), StdRandom.uniform(0.0, 1.0));
        kdtree.nearest(query);
        endTime = System.nanoTime() - startTime;
        count++;
      }
      kdTreeAvg = kdTreeAvg + count;
      System.out.println("KdTree Nearest/sec: " + count);

      startTime = System.nanoTime();
      endTime = System.nanoTime() - startTime;
      count = 0;

      while ((float) endTime / 1000000000 < 1) {
        Point2D query = new Point2D(StdRandom.uniform(0.0, 1.0), StdRandom.uniform(0.0, 1.0));
        brute.nearest(query);
        endTime = System.nanoTime() - startTime;
        count++;
      }
      bruteAvg = bruteAvg + count;
      System.out.println("Brute Nearest/sec: " + count);
    }
    
    kdTreeAvg = (float)kdTreeAvg/runFor;
    bruteAvg = (float)bruteAvg/runFor;
    
    System.out.println("KdTree avg Nearest/sec: " + kdTreeAvg);
    System.out.println("Brute avg Nearest/sec: " + bruteAvg);    
  }
}
