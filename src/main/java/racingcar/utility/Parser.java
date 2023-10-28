package racingcar.utility;

import racingcar.validator.ConstraintValidator;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String COMMA = ",";

    private Parser() {
    }

    public static List<String> parseCarNames(final String input) {
        return Arrays.stream(input.split(COMMA))
                .toList();
    }

    public static int parseRoundCount(final String input) {
        ConstraintValidator.validateNumber(input);
        return Integer.parseInt(input);
    }
}
