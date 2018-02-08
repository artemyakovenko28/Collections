package _0_introduction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class App00 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());

        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list);

        System.out.println(list.contains("x"));
        System.out.println(list.contains("b"));

        System.out.println(list.remove("xxx"));
        System.out.println(list.remove("a"));

        System.out.println(list);
    }
}

class Person {
    private List<String> phones;

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
