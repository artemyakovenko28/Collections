package _0_introduction;

public class App21x {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Mike", 45);
        System.out.println(pair);
        Pair<String, Pair<String, Pair<Integer, Integer>>> quadro0;
        Pair<Pair<Pair<String, String>, Integer>, Integer> quadro1;
    }
}

class Pair<A, B> {
    public final A first;
    public final B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}