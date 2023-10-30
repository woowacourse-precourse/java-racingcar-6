package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringChanger {

    private StringChanger() {
    }

    public static String stringToTrimmedString(String string) {
        return string.trim();
    }

    public static List<String> stringToStringList(String string) {
        return Arrays.stream(string.split(",", -1))
                .map(String::trim).collect(Collectors.toList());
    }

    public static int stringToInteger(String string) {
        return Integer.parseInt(string);
    }

    public static String cutLastRegex(StringBuilder stringBuilder) {
        int cutLength = stringBuilder.length() - ", ".length();
        return stringBuilder.substring(0, cutLength);
    }

}
