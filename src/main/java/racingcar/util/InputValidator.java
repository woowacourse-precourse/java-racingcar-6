package racingcar.util;

import java.util.List;

public class InputValidator {
    private static final String INVALID_NAME_LENGTH = "자동차의 이름 길이는 1이상 5이하입니다.";

    public void validateCarNames(List<String> carNames) {
        checkNameLength(carNames);
    }

    private void checkNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException(INVALID_NAME_LENGTH);
            }
        }
    }
}
