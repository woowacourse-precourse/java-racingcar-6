package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Util {
    public boolean isNullOrEmpty(String string) {
        if (string == null) {
            return true;
        }
        if (string.isEmpty()) {
            return true;
        }
        if (string.isBlank()) {
            return true;
        }
        return false;
    }

    public List<String> splitByComma(String string) {
        String[] carNameArray = string.split(",", -1);
        return Arrays.asList(carNameArray);
    }
}
