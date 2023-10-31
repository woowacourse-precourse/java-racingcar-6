package racingcar.util;

import java.util.List;

import static racingcar.enums.CarConstant.MAX_NAME_LENGTH;
import static racingcar.enums.CarConstant.MIN_NAME_LENGTH;
import static racingcar.enums.ExceptionMessage.INVALID_ATTEMPT_NUMBER_RANGE_EXCEPTION_MESSAGE;
import static racingcar.enums.ExceptionMessage.INVALID_NAME_LENGTH_EXCEPTION_MESSAGE;
import static racingcar.enums.ExceptionMessage.INVALID_NUMBER_EXCEPTION_MESSAGE;
import static racingcar.enums.RaceConstant.MIN_ATTEMPT_NUMBER;
import static racingcar.enums.RegexConstant.DIGIT_REGEX;

public class InputValidator {
    public static void validateCarNames(List<String> carNames) {
        validateNameLength(carNames);
    }

    private static void validateNameLength(List<String> carNames) {
        boolean validLength = carNames.stream()
                .allMatch(InputValidator::isNameLengthValid);

        if (!validLength) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private static boolean isNameLengthValid(String name) {
        int nameLength = name.length();

        return nameLength >= MIN_NAME_LENGTH.getNumber() && nameLength <= MAX_NAME_LENGTH.getNumber();
    }

    public static void validateAttemptNumber(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(INVALID_NUMBER_EXCEPTION_MESSAGE.getMessage());
        }
        if (!isRange(input)) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_NUMBER_RANGE_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private static boolean isNumber(String number) {
        return number.matches(DIGIT_REGEX.getRegex());
    }

    private static boolean isRange(String number) {
        return Integer.parseInt(number) >= MIN_ATTEMPT_NUMBER.getNumber();
    }
}
