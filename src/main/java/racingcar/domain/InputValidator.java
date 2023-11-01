package racingcar.domain;

import java.util.List;

public class InputValidator {
    public void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    public void validateNumAttempts(int numAttempts) {
        if (numAttempts < 1) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
    }
}
