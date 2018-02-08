package equals;

import java.util.Arrays;

public class StringArray1 {
    public final String[] array;

    public StringArray1(String[] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        StringArray0 that = (StringArray0) obj;
        return Arrays.equals(this.array, that.array);
    }
}
