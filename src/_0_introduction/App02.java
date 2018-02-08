package _0_introduction;

import java.util.HashSet;
import java.util.Set;

public class App02 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("b");
        set.add("c");

        System.out.println(set);

        System.out.println(set);

        set.remove(2);
        System.out.println(set);
    }
}
