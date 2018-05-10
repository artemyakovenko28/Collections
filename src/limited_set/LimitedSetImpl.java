package limited_set;

import java.util.Arrays;

public class LimitedSetImpl<T> implements LimitedSet<T> {

    /** Capacity of set */
    private final static int CAPACITY = 10;
    /** Data storage for element */
    private T[] data;
    /** Actual number of element in set */
    private int size = 0;

    /** Array for counting the number of contains() call of each element */
    public int[] hits = new int[CAPACITY];

    @SuppressWarnings("unchecked") // this cast is safe
    public LimitedSetImpl() {
        this.data = (T[]) new Object[CAPACITY];

    }

    /**
     * Add an element to this set. If, when adding element,
     * the size of the set exceeds 10 - then it is deleted
     * element to which there was the least number of hits (calls of the contains () method)
     * If there are several such elements, first one of them is deleted.
     * @param t element to add
     */
    @Override
    public void add(T t) {
        if (size == 10) {
            int indexOfMinHits = 0;
            if (t == null) { // check for null to prevent NullPointerException
                for (int i = 0; i < size; i++) {
                    if (data[i] == null) { // check if set contains specified element then do nothing
                        return;
                    }
                    if (hits[i] < hits[indexOfMinHits]) { // find element with min calls of contains()
                        indexOfMinHits = i;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (data[i].equals(t)) {
                        return;
                    }
                    if (hits[i] < hits[indexOfMinHits]) {
                        indexOfMinHits = i;
                    }
                }
            }
            data[indexOfMinHits] = t;
            hits[indexOfMinHits] = 0; // set to zero number of hits of added element
        } else {
            if (t == null) {
                for (int i = 0; i < size; i++) {
                    if (data[i] == null) {
                        return;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (data[i].equals(t)) {
                        return;
                    }
                }
            }
            data[size] = t;
            hits[size] = 0;
            size++;
        }
    }

    /**
     * Removes the first occurrence of the specified element from this set,
     * if it is present.  If the set does not contain the element, it is
     * unchanged.
     * @param t element to remove
     * @return {@code true} - if remove successfully; {@code false} - otherwise
     */
    @Override
    public boolean remove(T t) {
        if (t == null) { // check for null to prevent NullPointerException
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    actualRemove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(t)) {
                    actualRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes an element from this set by specified index.
     * If the set does not contain the element, it is unchanged.
     * @param index index of element to remove
     */
    private void actualRemove(int index) {
        int numMoved = size - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        System.arraycopy(hits, index + 1, hits, index, numMoved);
        int last = size - 1;
        data[last] = null; // let GC do its work :)
        hits[last] = 0;
        size--;
    }

    /**
     * Returns {@code true} if this set contains the specified element.
     * @param t element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    @Override
    public boolean contains(T t) {
        if (t == null) { // check for null to prevent NullPointerException
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    hits[i]++;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(t)) {
                    hits[i]++; // increase the number of contains() call for specified element
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LimitedSetImpl<?> that = (LimitedSetImpl<?>) o;

        if (size != that.size) return false;
        return Arrays.equals(data, that.data);
    }


    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(data[i]).append(" ");
        }
        return result.toString();
    }
}
