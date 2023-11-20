package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String COMMA = ",";

    public static List<String> splitByCommaConvertToList(String input) {
        String[] splitResult = input.split(COMMA);
        return Arrays.stream(splitResult)
                .map(String::trim)
                .toList();
    }
}