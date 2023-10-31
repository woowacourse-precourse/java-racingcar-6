package racingcar.utils;

import static racingcar.utils.Constants.INCLUDING_BLANK;
import static racingcar.utils.Constants.SPLITTER_OF_NAMES;
import static racingcar.utils.Constants.START_OF_STRING;

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
        return Arrays.stream(string.split(SPLITTER_OF_NAMES, INCLUDING_BLANK))
                .map(String::trim).collect(Collectors.toList());
    }

    public static int stringToInteger(String string) {
        return Integer.parseInt(string);
    }

    public static String cutLastRegex(StringBuilder stringBuilder, String regex) {
        int cutLength = stringBuilder.length() - regex.length();

        return stringBuilder.substring(START_OF_STRING, cutLength);
    }

}
