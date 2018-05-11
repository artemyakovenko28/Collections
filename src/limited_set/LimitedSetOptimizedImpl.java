package limited_set;

import java.util.*;

public class LimitedSetOptimizedImpl<T> implements LimitedSet<T> {

    private final static int CAPACITY = 10;
    private Map<T, Integer> data;

    public LimitedSetOptimizedImpl() {
        this.data = new HashMap<>(CAPACITY);
    }

    @Override
    public void add(T t) {
        if (data.size() == CAPACITY) {
            if (data.containsKey(t)) {
                return;
            }
            Map.Entry<T, Integer> min = null;
            for (Map.Entry<T, Integer> entry : data.entrySet()) {
                if (min == null || entry.getValue() < min.getValue()) {
                    min = entry;
                }
            }
            data.remove(min.getKey());
            data.put(t, 0);
        } else {
            if (data.containsKey(t)) {
                return;
            }
            data.put(t, 0);
        }
    }

    @Override
    public boolean remove(T t) {
        return data.remove(t) != null;
    }

    @Override
    public boolean contains(T t) {
        boolean result = data.containsKey(t);
        if (result) {
            Integer amountOfHits = data.get(t);
            data.put(t, ++amountOfHits);
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

    public String printHits() {
        return data.values().toString();
    }
}