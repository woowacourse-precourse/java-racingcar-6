package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static int stringToInt(String strInput) {
        return Integer.parseInt(strInput);
    }

    public static List<String> stringToStringList(String strInput) {
        return Arrays.asList(strInput.split(","));
    }
}
