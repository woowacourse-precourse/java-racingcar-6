package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<String> stringToStringList(final String input, final String splitter) {
        return Arrays.stream(input.split(splitter))
                .map(String::trim)
                .toList();
    }

    public static int stringToInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
