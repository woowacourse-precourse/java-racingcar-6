package racingcar.utils;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;

public class CarNameValidation {

    private static final String SPLIT_STANDARD = ",";
    private static final String NUMERIC = ".*\\d.*";
    private static final Integer MAX_CAR_NAME_LENGTH = 5;

    private static final String WHITESPACE_MESSAGE = "공백을 입력할 수 없습니다.";
    private static final String BLANK_INPUT_MESSAGE = "입력값이 존재하지 않습니다.";
    private static final String LENGTH_EXCEED_MESSAGE = "5글자를 초과하는 이름은 입력할 수 없습니다.";
    private static final String NUMERIC_NAME_MESSAGE = "이름에 숫자가 들어갈 수 없습니다.";

    public void validateUserInput(String inputCarName) {
        String[] carNames = inputCarName.split(SPLIT_STANDARD);

        if (Arrays.stream(carNames).allMatch(CarNameValidation::hasWhiteSpace)) {
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

    private static boolean isBlank(String carNames) {
        return carNames.isBlank();
    }

    private static boolean hasWhiteSpace(String carNames) {
        return StringUtils.containsWhitespace(carNames);
    }


    private static Boolean isCarNameLengthValid(String carName) {
        return carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    private static boolean isNumeric(String carName) {
        return !carName.matches(NUMERIC);
    }
}
