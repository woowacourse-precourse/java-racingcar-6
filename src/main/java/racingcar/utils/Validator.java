package racingcar.utils;

import java.util.List;

public class Validator {
    private static final int VALID_CAR_NAME_MAX_LENGTH = 5;

    private Validator() {} //인스턴스화 방지

    public static void checkCarNameLengthValid(String carName) {
        if (carName.length() > VALID_CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicateCarName(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCarNameEmpty(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCarNameContainsWhiteSpace(String carName) {
        if (carName.length() != carName.trim().length()) {
            throw new IllegalArgumentException();
        }
    }
}
