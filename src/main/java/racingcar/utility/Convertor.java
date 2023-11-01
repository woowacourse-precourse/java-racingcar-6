package racingcar.utility;

import java.util.Arrays;
import java.util.List;

public final class Convertor {

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
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
    }

}
