package labs.Iterable_Iterator;

import java.util.Iterator;

public class MergeIterator implements Iterator<Integer> {
    private final Iterator<Integer> it0;
    private final Iterator<Integer> it1;
    //    private int cursor;
    private int cursor0;
    private int cursor1;

    public MergeIterator(Iterator<Integer> it0, Iterator<Integer> it1) {
        this.it0 = it0;
        this.it1 = it1;
        if (it0.hasNext()) {
            cursor0 = it0.next();
        }
        if (it1.hasNext()) {
            cursor1 = it1.next();
        }
    }

    @Override
    public boolean hasNext() {
        return it0.hasNext() || it1.hasNext();
    }

    @Override
    public Integer next() {
        if (it0.hasNext() && it1.hasNext()) {
            if (cursor0 < cursor1) {
                int value = cursor0;
                cursor0 = it0.next();
                return value;
            } else {
                int value = cursor1;
                cursor1 = it1.next();
                return value;
            }
        } else {
            if (it0.hasNext()) {
                int value = cursor0;
                cursor0 = it0.next();
                return value;
            } else {
                int value = cursor1;
                cursor1 = it1.next();
                return value;
            }
        }
    }
}
