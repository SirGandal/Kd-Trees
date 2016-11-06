import java.util.ArrayList;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

public class PointSET {
  private SET<Point2D> points;

  // construct an empty set of points
  public PointSET() {
    this.points = new SET<Point2D>();
  }

  // is the set empty?
  public boolean isEmpty() {
    return this.points.isEmpty();
  }

  // number of points in the set
  public int size() {
    return this.points.size();
  }

  // add the point to the set (if it is not already in the set)
  public void insert(Point2D p) {
    if (p == null) {
      throw new java.lang.NullPointerException();
    }

    if (!this.points.contains(p)) {
      this.points.add(p);
    }
  }

  // does the set contain point p?
  public boolean contains(Point2D p) {
    return this.points.contains(p);
  }

  // draw all points to standard draw
  public void draw() {
    // StdDraw.setPenColor(StdDraw.BLACK);
    // StdDraw.setPenRadius(0.01);
    for (Point2D p : this.points) {
      p.draw();
    }
    // StdDraw.show();
  }

  // all points that are inside the rectangle
  public Iterable<Point2D> range(RectHV rect) {
    ArrayList<Point2D> pointsInRange = new ArrayList<Point2D>();
    for (Point2D p : this.points) {
      if (rect.contains(p)) {
        pointsInRange.add(p);
      }
    }
    return pointsInRange;
  }

  // a nearest neighbor in the set to point p; null if the set is empty
  public Point2D nearest(Point2D p) {
    // initialize to max distance possible in unit square
    double minDistance = (new Point2D(0, 0)).distanceTo(new Point2D(1, 1));
    Point2D pointCandidate = null;

    for (Point2D point : this.points) {
      double currentPointDistance = p.distanceTo(point);
      if (currentPointDistance <= minDistance) {
        pointCandidate = point;
        minDistance = currentPointDistance;
      }
    }

    return pointCandidate;
  }

  // unit testing of the methods (optional)
  public static void main(String[] args) {

  }
}
