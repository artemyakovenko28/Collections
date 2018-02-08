package _0_introduction;

public class App11 {
    public static void main(String[] args) {
        String[] strArr = {"Mike"};
        Object[] objArr = strArr;
        objArr[0] = new int[] {10, 20, 30};

        String value = strArr[0];
        System.out.println(value);
    }
}
