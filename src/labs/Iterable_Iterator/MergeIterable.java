package labs.Iterable_Iterator;

import java.util.Iterator;

public class MergeIterable implements Iterable<Integer> {
    private Iterable<Integer> iter0;
    private Iterable<Integer> iter1;

    public MergeIterable(Iterable<Integer> iter0, Iterable<Integer> iter1) {
        this.iter0 = iter0;
        this.iter1 = iter1;
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> it0 = iter0.iterator();
        Iterator<Integer> it1 = iter1.iterator();
        return new MergeIterator(it0, it1);
    }
}
