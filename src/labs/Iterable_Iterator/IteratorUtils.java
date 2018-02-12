package labs.Iterable_Iterator;

public class IteratorUtils {
    public static Iterable<Integer> interval(int left, int right) {
        return new IntervalIterable(left, right);
    }

    public static Iterable<Integer> squares(int left, int right) {
        return new SquareIterable(left, right);
    }

    public static Iterable<Integer> merge(Iterable<Integer> iter0, Iterable<Integer> iter1) {
        return new MergeIterable(iter0, iter1);
    }
}
