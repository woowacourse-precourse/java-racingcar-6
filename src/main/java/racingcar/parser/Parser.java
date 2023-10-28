package racingcar.parser;

import racingcar.exception.RacingCarException;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

import static racingcar.exception.ErrorMessage.CONTAIN_IMPROPER_LETTER;

public class Parser {
    private static final String DELIMITER = ",";

    private Parser() {
    }

    public static List<String> parseCarNames(final String input) {
        InputValidator.validateEndsWithComma(input);

        List<String> names = Arrays
                .stream(input.split(DELIMITER))
                .toList();

        InputValidator.validateDuplicated(names);
        return names;
    }

    public static int parseRoundCount(final String input) {
        int roundCount = extractParse(input);
        InputValidator.validateRoundCount(roundCount);
        return roundCount;
    }

    private static int extractParse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw RacingCarException.of(CONTAIN_IMPROPER_LETTER);
        }
    }
}
