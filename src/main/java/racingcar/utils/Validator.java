package racingcar.utils;

import java.math.BigInteger;
import java.util.List;

public class Validator {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_ROUND_VALUE = 0;
    private static final String NULL_ERROR_MESSAGE = "입력은 null이 될 수 없습니다.";
    private static final String INVALID_LENGTH_ERROR_MESSAGE = "자동차 이름의 길이의 범위는 (1~5) 이어야 합니다.";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "숫자만 입력할 수 있습니다.";
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "음수는 입력할 수 없습니다.";

    private Validator() {
    }

    public static void validateCarNames(String input) {
        checkNull(input);

        List<String> carNames = Parser.parseStringToList(input);
        carNames.stream()
                .forEach(Validator::checkValidLength);
    }

    public static void validateRoundNumber(String input) {
        checkNull(input);
        checkNumeric(input);
        checkNegative(input);
    }

    private static void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private static void checkValidLength(String input) {
        int length = input.length();
        if (!(MIN_NAME_LENGTH <= length && length <= MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void checkNumeric(String input) {
        char[] inputArray = input.toCharArray();
        for (char ch : inputArray) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
            }
        }
    }

    private static void checkNegative(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber < MIN_ROUND_VALUE) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void checkNumberBound(String input) {

    }
}
