package _3_tree_set;

import java.util.Collections;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class testStr {
    public static void main(String[] args) {
        NavigableSet<String> set1 = new TreeSet<>(new StrComparator());
        Collections.addAll(set1, "a", "ax", "ay", "b", "c");
        System.out.println(set1.toString());
    }
}

class StrComparator implements Comparator<String> {

    @Override
    public int compare(String str0, String str1) {
        int lengthDiff = str0.length() - str1.length();
        if (lengthDiff != 0) {
            return lengthDiff;
        } else {
            return str0.compareTo(str1);
        }
    }
}
