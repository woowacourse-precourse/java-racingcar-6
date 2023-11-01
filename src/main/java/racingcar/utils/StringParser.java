package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    public static List<String> splitStringWithComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    public static int parseStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
