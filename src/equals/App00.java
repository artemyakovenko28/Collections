package equals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App00 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        System.out.println("list: " + list);
        System.out.println("contains: " + list.contains(0));
        System.out.println("remove: " + list.remove(Integer.valueOf(0)));
        System.out.println("list: " + list);
        int[] a = null;
        int[] b = null;
        System.out.println(Arrays.equals(a, b));
    }
}
