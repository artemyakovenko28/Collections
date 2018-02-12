package labs.equals_hashCode_toString;

public class EntityA {
    private int age;
    private int height;
    private String name;

    public EntityA(int age, int height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        EntityA that = (EntityA) obj;
        if (this.age != that.age) return false;
        if (this.height != that.height) return false;
        if (this.name == null) {
            return that.name == null;
        } else {
            if (that.name == null) {
                return false;
            } else {
                return this.name.equals(that.name);
            }
        }
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + height;
        if (name != null) {
            result = 31 * result + name.hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        return "EntityA{" + "age=" + age +
                ", height=" + height +
                ", name='" + name + '\'' + '}';
    }
}
