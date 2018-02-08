package _0_introduction;

public class App10 {
    public static void main(String[] args) {
        WithVersion<String> strV = new WithVersion<>("Mike" , 10);
        WithVersion<int[]> intArrV = new WithVersion<>(new int[] {10, 20}, 10);
    }
}

class WithVersion<T> {
    private T value;
    private int version;

    public WithVersion(T value, int version) {
        this.value = value;
        this.version = version;
    }

    public T getValue() {
        return value;
    }

    public int getVersion() {
        return version;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}