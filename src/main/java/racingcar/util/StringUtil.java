package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static List<String> convertToList(final String str) {
        return Arrays.stream(str.split(","))
                .map(String::trim)
                .toList();
    }

    public static String convertToString(List<String> list) {
        return String.join("\n\n", list);
    }

    public static String convertToString(int number) {
        return "-".repeat(number);
    }
}
