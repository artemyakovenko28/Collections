package ArrayList_vs_LinkedList;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.currentTimeMillis;

public class _0_TestListGet {
    static int LIST_LENGTH = 100_000;
    static int OPERATION_COUNT = 100_000;

    public static void main(String[] args) {
        // INIT PARAMS
        int elemIndex = LIST_LENGTH / 2;
//        int elemIndex = LIST_LENGTH - 1;
//        List<String> list = new LinkedList<>();
        List<String> list = new ArrayList<>();

        // FILL
        for (int k = 0; k < LIST_LENGTH; k++) {
            list.add("A");
        }

        // TEST
        long startTime = currentTimeMillis();
        for (int k = 0; k < OPERATION_COUNT; k++) {
            list.get(elemIndex);
        }
        long stopTime = currentTimeMillis();
        System.out.println("dT: " + (stopTime - startTime));
    }
}
