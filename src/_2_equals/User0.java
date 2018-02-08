package _2_equals;

public class User0 {
    String name;
    int age;

    User0(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User0{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
