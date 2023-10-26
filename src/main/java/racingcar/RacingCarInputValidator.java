package racingcar;

import java.util.List;

public class RacingCarInputValidator {

    public static final int MAX_CAR_NAME_LENGTH = 5;

    public void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateLength(carName);
        }
    }

    private void validateLength(String carName) {
        if (carName.isEmpty() || MAX_CAR_NAME_LENGTH < carName.length()) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자 이하만 가능합니다.");
        }
    }
}
