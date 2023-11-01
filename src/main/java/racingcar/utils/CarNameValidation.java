package racingcar.utils;

import java.util.Arrays;

import static racingcar.message.IllegalArgumentExceptionMessage.*;

public class CarNameValidation {

    private static final String SPLIT_STANDARD = ",";
    private static final String NUMERIC = ".*\\d.*";
    private static final Integer MAX_CAR_NAME_LENGTH = 5;

    public void validateUserInput(String inputCarName) {
        String[] carNames = inputCarName.split(SPLIT_STANDARD);

        if (!Arrays.stream(carNames).allMatch(CarNameValidation::hasWhiteSpace)) {
            throw new IllegalArgumentException(WHITESPACE_MESSAGE);
        }

        if (Arrays.stream(carNames).allMatch(CarNameValidation::isBlank)) {
            throw new IllegalArgumentException(BLANK_INPUT_MESSAGE);
        }

        if (!Arrays.stream(carNames).allMatch(CarNameValidation::isCarNameLengthValid)) {
            throw new IllegalArgumentException(LENGTH_EXCEED_MESSAGE);
        }

        if (!Arrays.stream(carNames).allMatch(CarNameValidation::isNumeric)) {
            throw new IllegalArgumentException(NUMERIC_NAME_MESSAGE);
        }
    }

    private static boolean isBlank(String carName) {
        return carName.isBlank();
    }

    private static boolean hasWhiteSpace(String carName) {
        return carName.equals(carName.trim());
    }


    private static Boolean isCarNameLengthValid(String carName) {
        return carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    private static boolean isNumeric(String carName) {
        return !carName.matches(NUMERIC);
    }
}
