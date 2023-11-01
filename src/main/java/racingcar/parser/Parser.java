package racingcar.parser;

import racingcar.exception.ExceptionMessage;
import racingcar.validator.TryTimesValidator;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String COMMA = ",";

    private Parser() {
        throw new AssertionError();
    }

    public static List<String> parseCarNames(String carNames) {
        validateIfIsBlank(carNames);
        return createCarList(carNames);
    }

    public static int parseTryTimes(String tryTimes) {
        validateIfIsBlank(tryTimes);
        TryTimesValidator.validateNumber(tryTimes);
        return Integer.parseInt(tryTimes);
    }

    private static List<String> createCarList(String carNames) {
        return Arrays.stream(carNames.split(COMMA))
                .map(String::trim)
                .toList();
    }

    private static void validateIfIsBlank(String input) {
        if (input.isEmpty()) {
            throw ExceptionMessage.INPUT_BLANK.getException();
        }
    }
}
