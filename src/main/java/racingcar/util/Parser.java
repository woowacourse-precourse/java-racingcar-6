package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final int SPLIT_LIMIT_NUMBER = -1;

    public static List<String> parseCarNames(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter, SPLIT_LIMIT_NUMBER))
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
