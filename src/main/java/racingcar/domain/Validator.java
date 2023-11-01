package racingcar.domain;

import java.util.List;

public class Validator {

    private static final String CAR_NAME_BLANK_EXCEPTION = "[ERROR] 자동차의 이름은 공백을 입력 할 수 없습니다.";
    private static final String CAR_NAME_LENGTH_EXCEPTION = "[ERROR] 자동차의 이름은 최대 5자까지 입력 가능합니다.";
    private static final String NOT_NUMBER_EXCEPTION = "[ERROR] 숫자만 입력해주세요.";

    public static void validateBlank(String carName) {
        String ridBlank = carName.replace(" ", "");
        if (ridBlank.length() == 0) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION);
        }
    }

    public static void validateLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION);
        }
    }

    public static void validateCarName(List<String> carNames) {
        carNames.forEach(carName -> {
            validateBlank(carName);
            validateLength(carName);
        });
    }

    public static void validateTrialCount(String trialNumber) {
        if (trialNumber.matches("\\d+")) {
            return;
        }
        throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
    }
}
