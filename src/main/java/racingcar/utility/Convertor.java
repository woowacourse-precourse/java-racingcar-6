package racingcar.utility;

import java.util.Arrays;
import java.util.List;

public final class Convertor {

    private static final String INVALID_VALUE_TO_PARSE_INT_EXCEPTION_MESSAGE = "숫자로 형변환할 수 없는 값입니다.";

    public static List<String> split(String string, String delimiter) {
        String[] strings = string.split(delimiter);
        return Arrays.stream(strings)
                .toList();
    }

    public static List<String> trimStrings(List<String> strings) {
        return strings.stream()
                .map(String::trim)
                .toList();
    }

    public static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_VALUE_TO_PARSE_INT_EXCEPTION_MESSAGE);
        }
    }

}
