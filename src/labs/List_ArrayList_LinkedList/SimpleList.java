package labs.List_ArrayList_LinkedList;

import java.util.Iterator;

public interface SimpleList<T> extends Iterable<T> {
    // *** *** *** ADD *** *** ***
    public boolean add(T newElement);

    public void add(int index, T element);

    // *** *** *** READ *** *** ***
    public T get(int index);

    public Iterator<T> iterator();

    // *** *** *** CHECK *** *** ***
    public boolean contains(Object hasElement);

    public int size();

    public boolean isEmpty();

    // *** *** *** MUTATE *** *** ***
    public T set(int index, T newElement);

    // *** *** *** REMOVE *** *** ***
    public boolean remove(Object o);

    public T remove(int index);
}
