package labs.Iterable_Iterator.InputStream_Iterator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ISToIteratorAdapter implements Iterator<Integer> {
    private final InputStream is;
    private int cursor;

    public ISToIteratorAdapter(InputStream is) {
        this.is = is;
        cursor = readByte();
    }

    @Override
    public boolean hasNext() {
        return cursor != -1;
    }

    @Override
    public Integer next() {
        int value = cursor;
        cursor = readByte();
        return value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    private int readByte() {
        int readByte = 0;
        try {
            readByte = is.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readByte;
    }
}
