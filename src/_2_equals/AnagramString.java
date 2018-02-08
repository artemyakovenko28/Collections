package _2_equals;

import java.util.*;

public class AnagramString {
    public final String value;

    AnagramString(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        AnagramString that = (AnagramString) obj;
        char[] chA = this.value.toCharArray();
        char[] chB = that.value.toCharArray();
        Arrays.sort(chA);
        Arrays.sort(chB);
        return Arrays.equals(chA, chB);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return value;
    }
}

class ASDemo {
    public static void main(String[] args) {
        Set<AnagramString> set = new HashSet<>();
        System.out.println(set.add(new AnagramString("ABC")));
        System.out.println(set.add(new AnagramString("XYY")));
        System.out.println(set.add(new AnagramString("BCA")));
        System.out.println(set.contains(new AnagramString("BAC")));
        System.out.println(set);
    }
}

class ASDemo2 {
    public static void main(String[] args) {
        Map<AnagramString, Set<String>> map = new HashMap<>();
        //map.put(new AnagramString("ABC"), );
    }

}