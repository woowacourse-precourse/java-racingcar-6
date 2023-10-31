package racingcar.utils;

import java.util.List;

public class Validator {
    private static final int VALID_CAR_NAME_MAX_LENGTH = 5;
    private static final int ASCII_ONE = 49;
    private static final int ASCII_NINE = 57;
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

    public static void checkTrialNumberIsNaturalNumber(String trialNumber) {
        for (int i = 0; i < trialNumber.length(); i++) {
            if (!(trialNumber.charAt(i) >= ASCII_ONE && trialNumber.charAt(i) <= ASCII_NINE)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkTrialNumberIsEmpty(String trialNumber) {
        if (trialNumber == null || trialNumber.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
