package labs.Iterable_Iterator;

import static labs.Iterable_Iterator.IteratorUtils.interval;

public class TestInterval {
    public static void main(String[] args) {
        double[] array = {0.5, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5};

        for (int index : interval(0, array.length)) {
            System.out.print(" " + index);
        }
        System.out.println();

        for (int index : interval(0, array.length)) {
            System.out.print(" " + array[index]);
        }
        System.out.println();

        for (int index : interval(4, 8)) {
            System.out.print(" " + index);
        }
        System.out.println();

        for (int index : interval(4, 8)) {
            System.out.print(" " + array[index]);
        }
        System.out.println();
    }
}
