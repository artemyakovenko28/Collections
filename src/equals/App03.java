package equals;

import java.util.ArrayList;
import java.util.List;

public class App03 {
    public static void main(String[] args) {
        List<User1> list = new ArrayList<>();
        list.add(new User1("Anna", 18));
        list.add(new User1("Mike", 45));
        list.add(new User1("Sara", 25));
        System.out.println("list: " + list);
        System.out.println("contains: " + list.contains(new User1("Mike", 45)));
        System.out.println("remove: " + list.remove(new User1("Mike", 45)));
        System.out.println("list: " + list);
    }
}
