package _0_introduction;

import java.util.ArrayList;

public class App12 {
    public static void main(String[] args) {
        ArrayList<? extends Number> ref = new ArrayList<Integer>();

        Number n = null;
        //ref.add(n);

        Number xxx = ref.get(0);
    }
}
