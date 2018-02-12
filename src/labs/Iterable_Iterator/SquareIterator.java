package labs.Iterable_Iterator;

import java.util.Iterator;

public class SquareIterator implements Iterator<Integer> {
    private final int max;
    private int current;

    public SquareIterator(int left, int right) {
        this.max = right;
        double currentD = Math.sqrt(left);
        if ((currentD == Math.floor(currentD)) && !Double.isInfinite(currentD)) {
            current = (int) currentD;
        } else {
            current = ((int) currentD) + 1;
        }
    }

    @Override
    public boolean hasNext() {
        return current * current < max;
    }

    @Override
    public Integer next() {
        int value = current * current;
        current++;
        return value;
    }
}
