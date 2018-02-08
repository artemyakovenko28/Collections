package _0_introduction;

import java.util.HashSet;
import java.util.Set;

public class App03 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        System.out.println(set.add("a"));
        System.out.println(set.add("c"));
        System.out.println(set.add("b"));
        System.out.println(set.add("a"));

        System.out.println(set);
    }
}
