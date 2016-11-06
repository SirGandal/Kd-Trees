
/******************************************************************************
 *  Compilation:  javac NearestNeighborVisualizer.java
 *  Execution:    java NearestNeighborVisualizer input.txt
 *  Dependencies: PointSET.java KdTree.java
 *
 *  Read points from a file (specified as a command-line argument) and
 *  draw to standard draw. Highlight the closest point to the mouse.
 *
 *  The nearest neighbor according to the brute-force algorithm is drawn
 *  in red; the nearest neighbor using the kd-tree algorithm is drawn in blue.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

public class NearestNeighborVisualizer {

  public static void main(String[] args) {

    String filename = args[0];
    In in = new In(filename);

    StdDraw.enableDoubleBuffering();

    // initialize the two data structures with point from standard input
    PointSET brute = new PointSET();
    KdTree kdtree = new KdTree();
    while (!in.isEmpty()) {
      double x = in.readDouble();
      double y = in.readDouble();
      Point2D p = new Point2D(x, y);
      kdtree.insert(p);
      brute.insert(p);
    }

    Point2D lastQuery = new Point2D(1, 1);
    while (true) {

      // the location (x, y) of the mouse
      double x = StdDraw.mouseX();
      double y = StdDraw.mouseY();

      Point2D query = new Point2D(x, y);
      
      if (!lastQuery.equals(query)) {
        lastQuery = query;
        StdDraw.clear();

        drawBackground();

        // draw all of the points
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.setPenRadius(0.025);
        query.draw();

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        brute.draw();

        long startTime = System.nanoTime();
        Point2D bruteNearest = brute.nearest(query);
        long estimatedTime = System.nanoTime() - startTime;

        StdDraw.text(0.25, -0.025, "Brute: " + (float) estimatedTime / 1000000000 + " seconds");

        startTime = System.nanoTime();
        Point2D kdNearest = kdtree.nearest(query);
        estimatedTime = System.nanoTime() - startTime;

        StdDraw.text(0.75, -0.025, "Kd: " + (float) estimatedTime / 1000000000 + " seconds");

        // draw in red the nearest neighbor (using brute-force algorithm)
        StdDraw.setPenRadius(0.03);
        StdDraw.setPenColor(StdDraw.RED);
        bruteNearest.draw();

        StdDraw.setPenRadius(0.02);

        // draw in blue the nearest neighbor (using kd-tree algorithm)
        StdDraw.setPenColor(StdDraw.BLUE);
        kdNearest.draw();

        StdDraw.show();
      }
      StdDraw.pause(40);
    }
  }

  private static void drawBackground() {
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.filledSquare(0.5, 0.5, 0.55);
    StdDraw.setXscale(-0.05, 1.05);
    StdDraw.setYscale(-0.05, 1.05);
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.filledSquare(0.5, 0.5, 0.5);
  }
}
