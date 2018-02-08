package _0_introduction;

import java.util.HashMap;
import java.util.Map;

public class App20x {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println(map);
        System.out.println(map.put("Sprat", 25));
        System.out.println(map.put("Sardine", 10));
        System.out.println(map.put("Sardine", 15));
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("Salmon"));
        System.out.println(map.get("Sprat"));
        System.out.println(map.remove("Sprat"));
        System.out.println(map.remove("Salmon"));
        System.out.println(map.put("Sprat", 30));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());

    }
}
