package _0_introduction;

import java.util.ArrayList;

public class App13 {
    public static void main(String[] args) {
        ArrayList<? extends Integer> ref0 = null;
        ArrayList<? extends Number> ref1 = null;

        //ref0 = ref1;
        ref1 = ref0;

        ArrayList<? super Integer> ref3 = null;
        ArrayList<? super Number> ref4 = null;

        ref3 = ref4;
        //ref4 = ref3;


    }
}
