package labs.Iterable_Iterator.InputStream_Iterator;

import java.io.IOException;
import java.io.InputStream;

import static labs.Iterable_Iterator.IteratorUtils.interval;

public class IteratorToISAdapterTest {
    public static void main(String[] args) throws IOException {
        InputStream is
                = new IteratorToISAdapter(interval(0, 10).iterator());
        int k;
        while ((k = is.read()) != -1) {
            System.out.print(" " + k);
        }
    }
}
