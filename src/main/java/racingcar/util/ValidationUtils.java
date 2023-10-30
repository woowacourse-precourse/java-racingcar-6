package racingcar.util;

import static racingcar.enums.ExceptionMessage.CONTAINING_MORE_THAN_ONE_CAR;
import static racingcar.enums.ExceptionMessage.NOT_BLANK_NAME;
import static racingcar.enums.ExceptionMessage.NOT_TOO_LONG_INPUT;
import static racingcar.enums.ExceptionMessage.OVER_FIVE_LETTERS;
import static racingcar.enums.ExceptionMessage.SHOULD_BE_NUMBER;
import static racingcar.enums.StringPattern.TRIAL_COUNT;
import static racingcar.enums.Symbol.CAR_NAME_DELIMITER;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static final Pattern TRIAL_COUNT_PATTERN = Pattern.compile(TRIAL_COUNT.getPattern());

    private ValidationUtils() {
    }

    public static void validateCarNames(String input) {
        if (hasNameOver5Letters(input)) {
            throw new IllegalArgumentException(OVER_FIVE_LETTERS.getMessage());
        }

        if (notContainsComma(input)) {
            throw new IllegalArgumentException(CONTAINING_MORE_THAN_ONE_CAR.getMessage());
        }

        if (hasBlankName(input)) {
            throw new IllegalArgumentException(NOT_BLANK_NAME.getMessage());
        }

        if (isOver10000Letters(input)) {
            throw new IllegalArgumentException(NOT_TOO_LONG_INPUT.getMessage());
        }
    }

    private static boolean hasNameOver5Letters(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER.getValue()))
                .anyMatch(carName -> carName.length() > 5);
    }

    private static boolean notContainsComma(String input) {
        return !input.contains(CAR_NAME_DELIMITER.getValue());
    }

    private static boolean hasBlankName(String input) {
        return input == null
                || input.contains(CAR_NAME_DELIMITER.getValue().repeat(2));
    }

    private static boolean isOver10000Letters(String input) {
        return input.length() > 10000;
    }

    public static void validateTrialCount(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException(SHOULD_BE_NUMBER.getMessage());
        }
    }

    private static boolean isNotNumber(String input) {
        return !TRIAL_COUNT_PATTERN.matcher(input)
                .matches();
    }
}
