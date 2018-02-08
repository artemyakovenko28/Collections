package _2_equals;

import java.util.Objects;

public class User2 {
    String name;
    int age;

    User2(String name, int age) {
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
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
//        if (!(obj instanceof User2)) {
//            return false;
//        }
        User2 that = (User2) obj;
        if (this.age != that.age) {
            return false;
        }
        return Objects.equals(this.name, that.name);
    }
}
