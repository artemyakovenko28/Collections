package labs.List_ArrayList_LinkedList;

import limited_set.LimitedSet;
import limited_set.LimitedSetImpl;

public class Test {
    public static void main(String[] args) {
        LimitedSet<String> set = new LimitedSetImpl<>();
        for (int i = 0; i < 12; i++) {
            set.add(String.valueOf(i));
        }
        // expected: 11 1 2 3 4 5 6 7 8 9
        System.out.println(set);
        for (int i = 0; i < 9; i++) {
            set.contains(String.valueOf(i));
        }
        set.contains("11");
        set.add("elem1");
        // expected: 11 1 2 3 4 5 6 7 8 elem1
        System.out.println(set);
        set.remove("4");
        set.contains("elem1");
        for (int i = 2; i < 10; i++) {
            set.contains(String.valueOf(i));
        }
        // expected: elem1 1 2 3 5 6 7 8 9
        System.out.println(set);
        set.add("elem2");
        // expected: elem1 1 2 3 5 6 7 8 9 elem2
        System.out.println(set);
        //expected: elem1 1 2 3 5 6 7 8 9 elem3
        set.add("elem3");
        System.out.println(set);
    }
}
