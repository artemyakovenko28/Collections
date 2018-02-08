package equals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Point2D implements Comparable<Point2D>{
    private final int x;
    private final int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Point2D that = (Point2D) obj;

        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return "Point2D{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public int compareTo(Point2D that) {
        int dX = this.x -  that.x;
        if (dX != 0) {
            return dX;
        } else {
            return this.y - that.y;
        }
    }
}

class TestList {
    public static void main(String[] args) {
        List<Point2D> list = new ArrayList<>();
        list.add(new Point2D(0, 0));
        System.out.println(list);
        System.out.println(list.contains(new Point2D(0, 0)));
        System.out.println(list.remove(new Point2D(0, 0)));
        System.out.println(list);
    }
}

class TestSet {
    public static void main(String[] args) {
        Set<Point2D> set = new HashSet<>();
        set.add(new Point2D(0, 0));
        set.add(new Point2D(0, 0));
        set.add(new Point2D(1, 1));
        System.out.println(set);
        System.out.println(set.contains(new Point2D(0, 0)));
        System.out.println(set.remove(new Point2D(0, 0)));
        System.out.println(set);
    }
}
