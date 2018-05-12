package limited_set;

import java.util.*;

public class LimitedSetOptimizedImpl<T> implements LimitedSet<T> {

    private final static int CAPACITY = 10;
    private Map<T, Integer> data;
    private TreeMap<Integer, Set<T>> hits;

    public LimitedSetOptimizedImpl() {
        this.data = new HashMap<>(CAPACITY);
        this.hits = new TreeMap<>();
    }

    @Override
    public void add(T t) {
        if (data.size() == CAPACITY) {
            if (data.containsKey(t)) {
                return;
            }
            Set<T> minSet = hits.firstEntry().getValue();
            T elemToReplace = minSet.iterator().next();
            minSet.remove(elemToReplace);
            data.remove(elemToReplace);
            data.put(t, 0);
        } else {
            if (data.containsKey(t)) {
                return;
            }
            data.put(t, 0);
            hits.computeIfAbsent(0, k -> new HashSet<>());
            hits.get(0).add(t);
        }
    }

    @Override
    public boolean remove(T t) {
        Integer hitsAmount = data.remove(t);
        if (hitsAmount == null) {
            return false;
        }
        hits.get(hitsAmount).remove(t);
        return true;
    }

    @Override
    public boolean contains(T t) {
        boolean result = data.containsKey(t);
        if (result) {
            Integer amountOfHits = data.get(t);
            hits.get(amountOfHits).remove(t);
            ++amountOfHits;
            data.put(t, amountOfHits);
            hits.computeIfAbsent(amountOfHits, k -> new HashSet<>());
            hits.get(amountOfHits).add(t);
        }
        return result;
    }

    @Override
    public int size() {
        return data.keySet().size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LimitedSetOptimizedImpl<?> that = (LimitedSetOptimizedImpl<?>) o;

        return data.keySet().equals(that.data.keySet());
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public String toString() {
        return data.keySet().toString();
    }
}