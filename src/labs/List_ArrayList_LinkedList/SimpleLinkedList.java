package labs.List_ArrayList_LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SimpleLinkedList<E> implements SimpleList<E> {
    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;

    // *** *** *** ADD *** *** ***
    @Override
    public boolean add(E newElement) {
        final Node<E> tmp = last;
        final Node<E> newNode = new Node<>(tmp, newElement, null);
        last = newNode;
        if (tmp == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    // *** *** *** READ *** *** ***
    public E get(int index) {
        checkIndex(index);
        return node(index).item;
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        Node<E> cursor = first;
        Node<E> lastRet = null;

        Itr() {}

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            try {
                Node<E> current = cursor;
                E elem = current.item;
                lastRet = current;
                cursor = current.next;
                return elem;
            } catch (NullPointerException e) {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            if (lastRet == null) {
                throw new IllegalStateException();
            }
            unlink(lastRet);
            cursor = cursor.prev;
            lastRet = null;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }

    // *** *** *** CHECK *** *** ***
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // *** *** *** MUTATE *** *** ***
    public E set(int index, E newElement) {
        checkIndex(index);
        Node<E> foundNode = node(index);
        E oldVal = foundNode.item;
        foundNode.item = newElement;
        return oldVal;
    }

    // *** *** *** REMOVE *** *** ***
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            unlink(node(index));
            return true;
        } else {
            return false;
        }
    }

    public E remove(int index) {
        checkIndex(index);
        return unlink(node(index));
    }

    // *** *** *** OBJECT METHODS *** *** ***
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof SimpleList) return false;

        Iterator<E> it1 = this.iterator();
        Iterator<?> it2 = ((SimpleList<?>) o).iterator();

        while (it1.hasNext() && it2.hasNext()) {
            E thisElem = it1.next();
            Object thatElem = it2.next();
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
        return !(it1.hasNext() || it2.hasNext());
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (E elem : this) {
            result = 31 * result + (elem == null ? 0 : elem.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        Iterator<E> it = this.iterator();
        if (!it.hasNext()) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        result.append("[");
        for (; ; ) {
            E elem = it.next();
            result.append(elem);
            if (!it.hasNext()) {
                return result.append("]").toString();
            }
            result.append(",").append(" ");
        }
    }

    // ---------- internals ----------
    private void checkIndex(int index) {
        if (index < 0 || size - 1 < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private Node<E> node(int index) {
        if (index < size / 2) {
            Node<E> tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    private int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    private E unlink(Node<E> x) { //todo:
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private void linkLast(E e) { //todo:
        final Node<E> tmp = last;
        final Node<E> newNode = new Node<>(tmp, e, null);
        last = newNode;
        if (tmp == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
    }

    private void linkBefore(E e, Node<E> succ) { //todo:
        // assert succ != null;
        final Node<E> prev = succ.prev;
        final Node<E> newNode = new Node<>(prev, e, succ);
        succ.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    private static class Node<T> {
        private Node<T> prev;
        private T item;
        private Node<T> next;

        private Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
