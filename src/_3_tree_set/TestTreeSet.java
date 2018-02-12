package _3_tree_set;

import equals.Point2D;

import java.util.Set;
import java.util.TreeSet;

class TestTreeSet {
    public static void main(String[] args) {
        Set<Point2D> set = new TreeSet<>();
        set.add(new Point2D(10, 0));
        set.add(new Point2D(0, 0));
        set.add(new Point2D(0, 10));
        System.out.println(set);
    }
}