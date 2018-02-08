package _2_equals;

public class User1 {
    String name;
    int age;

    User1(String name, int age) {
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
        User1 that = (User1) obj;
        if (this.age != that.age) {
            return false;
        }

        if (this.name == null) {
            if (that.name == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (that.name == null) {
                return false;
            } else {
                return this.name.equals(that.name);
            }
        }
    }
}
