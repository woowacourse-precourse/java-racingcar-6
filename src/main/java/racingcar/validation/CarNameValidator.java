package racingcar.validation;

import java.util.List;

public class CarNameValidator {

    public static void validateCarNames(List<String> carNames) {
        validateNotEmpty(carNames);
    }

    private static void validateNotEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }
}
