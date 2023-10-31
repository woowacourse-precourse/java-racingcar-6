package racingcar.validator;

import static racingcar.controller.GameConstants.MAX_LENGTH;
import static racingcar.message.ErrorMessages.BLANK_ERROR;
import static racingcar.message.ErrorMessages.DUPLICATE_ERROR;
import static racingcar.message.ErrorMessages.NON_NUMERIC;
import static racingcar.message.ErrorMessages.NON_POSITIVE;
import static racingcar.message.ErrorMessages.OVER_AVAILABLE_LENGTH;

import java.util.List;

public class Validator {
    public static void validateAvailableLength(String input) {
        if (input.length() > MAX_LENGTH.getNumber()) {
            throw new IllegalArgumentException(OVER_AVAILABLE_LENGTH);
        }
    }

    public static void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR);
        }
    }

    public static void validateIsDuplicate(List<String> input) {
        long inputSize = input.size();
        long uniqueInputSize = input.stream()
                .distinct()
                .count();

        if (inputSize != uniqueInputSize) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    public static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NON_NUMERIC);
        }
    }

    public static void validateIsPositive(long tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(NON_POSITIVE);
        }
    }
}