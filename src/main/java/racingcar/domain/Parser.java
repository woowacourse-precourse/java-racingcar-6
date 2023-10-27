package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String COMMA = ",";

    private Parser() {
    }

    public static List<String> parseInput(final String input) {
        return Arrays.stream(input.split(COMMA))
                .toList();
    }
}
