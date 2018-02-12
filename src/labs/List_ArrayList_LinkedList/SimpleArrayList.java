package labs.List_ArrayList_LinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SimpleArrayList<E> implements SimpleList<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public SimpleArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public SimpleArrayList(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }


    // *** *** *** ADD *** *** ***
    @Override
    public boolean add(E element) {
        ensureCapacity(size + 1);
        data[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        rangeCheck(index);
        ensureCapacity(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    // *** *** *** READ *** *** ***
    @Override
    public E get(int index) {
        rangeCheck(index);
        return data[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        int cursor = 0;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        // prevent creating a synthetic constructor
        Itr() {}

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            try {
                int i = cursor;
                E next = get(i);
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            if (lastRet == -1) {
                throw new IllegalStateException();
            }
            try {
                SimpleArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (Exception ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }

    // *** *** *** CHECK *** *** ***
    @Override
    public boolean contains(Object element) {
        if (element == null) { // look for null
            for (int k = 0; k < size; k++) {
                if (null == data[k]) {
                    return true;
                }
            }
        } else { // look for !null
            for (int k = 0; k < size; k++) {
                if (element.equals(data[k])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // *** *** *** MUTATE *** *** ***
    @Override
    public E set(int index, E newElement) {
        rangeCheck(index);
        E oldElement = data[index];
        data[index] = newElement;
        return oldElement;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int k = 0; k < size; k++) {
                if (null == data[k]) {
                    remove(k);
                    return true;
                }
            }
        } else {
            for (int k = 0; k < size; k++) {
                if (o.equals(data[k])) {
                    remove(k);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldElement = data[index];
        int numMoved = size - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
        return oldElement;
    }


    // *** *** *** OBJECT METHODS *** *** ***

    @Override
    public String toString() {
        Iterator<E> it = this.iterator();
        if (!it.hasNext()) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        result.append("[");
        for(;;) {
            E elem = it.next();
            result.append(elem);
            if (!it.hasNext()) {
                return result.append("]").toString();
            }
            result.append(",").append(" ");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof SimpleList) return false;
        SimpleArrayList<?> that = (SimpleArrayList<?>) o;

        if (this.size() != that.size()) return false;
        Iterator<E> thisIt = this.iterator();
        Iterator<?> thatIt = that.iterator();

        while (thisIt.hasNext() && thatIt.hasNext()) {
            E thisElem = thisIt.next();
            Object thatElem = thatIt.next();
            if (thisElem == null) {
                return thatElem == null;
            } else {
                if (thatElem == null) {
                    return false;
                } else {
                    return thisElem.equals(thatElem);
                }
            }
        }
        return !(thisIt.hasNext() || thatIt.hasNext());
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (E elem : this) {
            if (elem == null) {
                result = 31 * result;
            } else {
                result = 31 * result + elem.hashCode();
            }
        }
        return result;
    }

    // ---------- internals ---------
    private void rangeCheck(int index) {
        if (index < 0 || size - 1 < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(minCapacity, data.length + (data.length >> 1));
            E[] newData = (E[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            this.data = newData;
        }
    }
}
