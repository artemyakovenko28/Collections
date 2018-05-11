package limited_set;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LimitedSetOptimizedImplTest {
    @Test
    public void test_add() {
        LimitedSet<Integer> set = new LimitedSetOptimizedImpl<>();
        for (int i = 0; i < 12; i++) {
            set.add(i);
        }

        LimitedSet<Integer> testSet = new LimitedSetOptimizedImpl<>();
        for (int i = 2; i < 12; i++) {
            testSet.add(i);
        }

        assertEquals(testSet, set);
    }

    @Test
    public void test_add_with_removing_element_with_min_hits() {
        LimitedSet<Integer> set = new LimitedSetOptimizedImpl<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        for (int i = 1; i < 10; i++) {
            set.contains(i);
        }
        set.add(100);

        LimitedSet<Integer> testSet = new LimitedSetOptimizedImpl<>();
        for (int i = 1; i < 10; i++) {
            testSet.add(i);
        }
        testSet.add(100);

        assertEquals(testSet, set);
    }

    @Test
    public void test_remove() {
        LimitedSet<Integer> set = new LimitedSetOptimizedImpl<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        set.remove(5);

        LimitedSet<Integer> testSet = new LimitedSetOptimizedImpl<>();
        testSet.add(0);
        testSet.add(2);
        testSet.add(1);
        testSet.add(4);
        testSet.add(3);
        testSet.add(7);
        testSet.add(6);
        testSet.add(8);
        testSet.add(9);

        assertEquals(testSet, set);
    }

    @Test
    public void test_contains() {
        LimitedSet<Integer> set = new LimitedSetOptimizedImpl<>();

        set.add(null);
        assertTrue(set.contains(null));

        set.add(20);
        assertTrue(set.contains(20));

        assertFalse(set.contains(50));
    }

    @Test
    public void test_size() {
        LimitedSet<Integer> set = new LimitedSetOptimizedImpl<>();
        for (int i = 0; i < 5; i++) {
            set.add(i);
        }

        assertThat(set.size(), is(5));
    }
}