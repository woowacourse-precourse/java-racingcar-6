package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<String> splitString(String string) {
        return Arrays.stream(string.split(","))
                .toList();
    }

    public static int convertStringToInt(String string) {
        return Integer.parseInt(string);
    }
}
