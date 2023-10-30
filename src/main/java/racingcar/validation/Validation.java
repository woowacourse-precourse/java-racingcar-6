package racingcar.validation;

import racingcar.util.NumberUtil;

public class Validation {
    private static final String EXCEPTION_MESSAGE_FOR_WRONG_LENGTH_OF_CAR_NAME =
            "올바르지 않은 자동차 이름입니다. 각 자동차 이름은 5글자 이하여야 합니다.";
    private static final String EXCEPTION_MESSAGE_FOR_NON_NUM =
            "정수가 아닙니다.";
    private static final String EXCEPTION_MESSAGE_FOR_NEGATIVE_NUMBER =
            "양의 정수를 입력하셔야 합니다.";

    public static void checkCarNames(String[] carNames) {
        for (String carName : carNames) {
            checkCarName(carName);
        }
    }

    private static void checkCarName(String carName) {
        if (carName.length() > 5 || carName.length() == 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_FOR_WRONG_LENGTH_OF_CAR_NAME);
        }
    }

    public static void checkIfInteger(String digit) {
        if (!NumberUtil.isInteger(digit)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_FOR_NON_NUM);
        }
    }

    public static void checkIfNonNegative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_FOR_NEGATIVE_NUMBER);
        }
    }
}
