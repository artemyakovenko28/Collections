package _2_equals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App02 {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("A", "B", "C"));
        list.add(Arrays.asList("D", "E", "F"));
        list.add(Arrays.asList("G", "H", "I"));
        System.out.println("list: " + list);
        System.out.println("contains: " + list.contains(Arrays.asList("A", "B", "C")));
        System.out.println("remove: " + list.remove(Arrays.asList("A", "B", "C")));
        System.out.println("list: " + list);
    }
}
