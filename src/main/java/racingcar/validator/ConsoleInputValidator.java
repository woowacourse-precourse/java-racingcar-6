package racingcar.validator;

import static racingcar.constant.ValidatorConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static racingcar.constant.ValidatorConstants.MAXIMUM_CAR_NAME_LENGTH;
import static racingcar.constant.ValidatorConstants.MINIMUM_PLAY_NUMBER;
import static racingcar.constant.ValidatorConstants.NOT_NUMBER_REGEX;
import static racingcar.constant.ValidatorConstants.NULL_REGEX;

import java.util.List;

public class ConsoleInputValidator {


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
        if (carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
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
        if (playNumber == MINIMUM_PLAY_NUMBER) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    private static void validatePlayNumberNotNegative(int playNumber) {
        if (playNumber < MINIMUM_PLAY_NUMBER) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }
}
