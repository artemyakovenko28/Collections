package limited_set;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LimitedSetImplTest {
    @Test
    public void test_LimitedSetImpl() {
        LimitedSetImpl<String> set = new LimitedSetImpl<>();
        for (int i = 0; i < 12; i++) {
            set.add(String.valueOf(i));
        }
        assertEquals(set.toString(), "11 1 2 3 4 5 6 7 8 9 ");

        for (int i = 0; i < 9; i++) {
            set.contains(String.valueOf(i));
        }
        set.contains("11");
        set.add("elem1");
        assertEquals(set.toString(), "11 1 2 3 4 5 6 7 8 elem1 ");

        set.remove("4");
        set.contains("elem1");
        for (int i = 2; i < 10; i++) {
            set.contains(String.valueOf(i));
        }
        assertEquals(set.toString(), "11 1 2 3 5 6 7 8 elem1 ");

        set.add("elem2");
        assertEquals(set.toString(), "11 1 2 3 5 6 7 8 elem1 elem2 ");

        set.add("elem3");
        assertEquals(set.toString(), "11 1 2 3 5 6 7 8 elem1 elem3 ");
    }
}