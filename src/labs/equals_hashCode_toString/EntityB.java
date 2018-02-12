package labs.equals_hashCode_toString;

import java.util.Arrays;

public class EntityB {
    private final String[][] stringArr;
    private final double[] doubleArr;

    public EntityB(String[][] stringArr, double[] doubleArr) {
        this.stringArr = stringArr;
        this.doubleArr = doubleArr;
    }

    public String[][] getStringArr() {
        return stringArr;
    }

    public double[] getDoubleArr() {
        return doubleArr;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (int i = 0; i < stringArr.length; i++) {
            for (int j = 0; j < stringArr[i].length; j++) {
                result = 31 * result + stringArr[i][j].hashCode();
            }
        }
//        result = 31 * result + Arrays.deepHashCode(stringArr);

        result = 31 * result + Arrays.hashCode(doubleArr);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        EntityB that = (EntityB) obj;
        if (!Arrays.deepEquals(this.stringArr, that.stringArr)) {
            return false;
        } else {
            return Arrays.equals(this.doubleArr, that.doubleArr);
        }
    }

    @Override
    public String toString() {
        return "EntityB{" +
                "stringArr=" + Arrays.deepToString(stringArr) +
                ", doubleArr=" + Arrays.toString(doubleArr) +
                '}';
    }
}
