package equals;

import java.util.Objects;

public class StringArray0 {
    public final String[] array;

    public StringArray0(String[] array) {
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
        if (this.array == null) {
            return that.array == null;
        } else {
            if (that.array == null) {
                return false;
            } else {
                // compare the lengths of arrays
                if (this.array.length != that.array.length) {
                    return false;
                } else {
                    // compare arrays element-by-element
                    for (int i = 0; i < this.array.length; i++) {
                        if (!Objects.equals(this.array[i], that.array[i])) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
    }
}
