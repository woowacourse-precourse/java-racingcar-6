package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Converter {
    private static final String COMMA = ",";

    private Converter() {
    }

    public static List<String> parseInput(final String input) {
        return Arrays.stream(input.split(COMMA))
                .toList();
    }

    public static int convertInputToInt(final String input) {
        Validator.validateNumber(input);
        return Integer.parseInt(input);
    }
}
