package racingcar.view;

import java.util.List;

public class ConsoleInputValidator {
    private static final IllegalArgumentException ILLEGAL_ARGUMENT_EXCEPTION = new IllegalArgumentException();
    private static final String NULL_REGEX = "(^null)";
    private static final String NOT_NUMBER_REGEX = "\\D";

    public static void validateInputString(String inputString) {
        validateInputNotNull(inputString);
        validateInputNotEmpty(inputString);
        validateInputNotBlank(inputString);
    }

    private static void validateInputNotNull(String inputString) {
        if (inputString == null || inputString.matches(NULL_REGEX)) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    private static void validateInputNotEmpty(String inputString) {
        if (inputString.isEmpty()) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    private static void validateInputNotBlank(String inputString) {
        if (inputString.isBlank()) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    public static void validateCarNames(List<String> carNames) {

        for (String carName : carNames) {
            validateCarNameNotEmpty(carName);
            validateCarNameNotBlank(carName);
            validateCarNameLengthNotLongerThan5(carName);
        }

    }

    private static void validateCarNameNotEmpty(String carName) {
        if (carName.isEmpty()) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    private static void validateCarNameNotBlank(String carName) {
        if (carName.isBlank()) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    private static void validateCarNameLengthNotLongerThan5(String carName) {
        if (carName.length() > 5) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    public static void validateInputIsNumber(String inputString) {
        if (inputString.matches(NOT_NUMBER_REGEX)) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    public static void validatePlayNumber(int inputNumber) {
        validatePlayNumberNotZero(inputNumber);
        validatePlayNumberNotNegative(inputNumber);
    }

    private static void validatePlayNumberNotZero(int playNumber) {
        if (playNumber == 0) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    private static void validatePlayNumberNotNegative(int playNumber) {
        if (playNumber < 0) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }
}
