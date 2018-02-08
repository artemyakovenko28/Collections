package _0_introduction;

import java.util.ArrayList;
import java.util.List;

public class App01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list.get(1));
        System.out.println(list.set(1, "xxx"));
        System.out.println(list);

        list.add(0, "ccc");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
    }
}
