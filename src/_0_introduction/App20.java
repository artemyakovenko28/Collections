package _0_introduction;

import java.util.*;

import static java.util.Arrays.asList;

public class App20 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(asList("A", "BB", "A"));
        System.out.println(list);
        List<String> list2 = new ArrayList<>(new HashSet<>(list));
        Collections.sort(list2);
        System.out.println(list2);

        list.add("CCC");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

//        Iterator<String> iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }

        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        for (String elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();

        Set<Integer> set = new HashSet<>(asList(4, 7, 78, 45, 67, 89, 12));
        for (Integer elem : set) {
            System.out.print(elem + " ");
        }
        System.out.println();

        Map<String, String> map = new HashMap<>();
        map.put("A", "*");
        map.put("B", "+");
        map.put("C", "-");
        for (Map.Entry<String, String> elem : map.entrySet()) {
            System.out.print(elem.getKey() + ":::" + elem.getValue() + " ");
        }

        for (Student elem : new Group()) {
            System.out.print(elem + " ");
        }
    }
}

class Student {}

class Group implements Iterable<Student> {

    @Override
    public Iterator<Student> iterator() {
        return null;
    }
}
