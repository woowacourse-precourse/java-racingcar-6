package racingcar;

import java.util.List;

public class RacingCarInputValidator {

    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String MAX_CAR_NAME_EXCEPTION = "자동차 이름은 최대 5자 이하만 가능합니다.";
    public static final String AVAILABLE_CHARACTER_REGEX = "[a-zA-Z0-9가-힣]*";
    public static final String AVAILABLE_CHARACTER_EXCEPTION = "자동차 이름은 한글, 영어, 숫자만 가능합니다.";

    public void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateLength(carName);
            validateCharacter(carName);
        }
    }

    private void validateLength(String carName) {
        if (carName.isEmpty() || MAX_CAR_NAME_LENGTH < carName.length()) {
            throw new IllegalArgumentException(MAX_CAR_NAME_EXCEPTION);
        }
    }

    private void validateCharacter(String carName) {
        if (!carName.matches(AVAILABLE_CHARACTER_REGEX)) {
            throw new IllegalArgumentException(AVAILABLE_CHARACTER_EXCEPTION);
        }
    }
}
