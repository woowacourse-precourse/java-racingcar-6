package racingcar.utils;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;

public class CarNameValidation {

    public void validateUserInput(String inputCarName) {
        String[] carNames = inputCarName.split(",");

        if (Arrays.stream(carNames).allMatch(CarNameValidation::hasWhiteSpace)) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }

        if (Arrays.stream(carNames).allMatch(CarNameValidation::isBlank)) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }

        if (!Arrays.stream(carNames).allMatch(CarNameValidation::isCarNameLengthValid)) {
            throw new IllegalArgumentException("5글자를 초과하는 이름은 입력할 수 없습니다.");
        }
        if (!Arrays.stream(carNames).allMatch(CarNameValidation::isNumeric)) {
            throw new IllegalArgumentException("이름에 숫자가 들어갈 수 없습니다.");
        }
    }

    private static boolean isBlank(String carNames) {
        return carNames.isBlank();
    }

    private static boolean hasWhiteSpace(String carNames) {
        return StringUtils.containsWhitespace(carNames);
    }


    private static Boolean isCarNameLengthValid(String carName) {
        return carName.length() <= 5;
    }

    private static boolean isNumeric(String carName) {
        return !carName.matches(".*\\d.*");
    }
}
