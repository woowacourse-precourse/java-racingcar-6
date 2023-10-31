package racingcar.game;

import java.util.List;
import java.util.Objects;

public final class GameArgumentValidator {

    public static void validateCarNames(List<String> cars) {
        if (Objects.isNull(cars) || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        for (String carName : cars) {
            if (carName.isBlank() || carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
    }

    public static void validateAttemptInput(String attempt) {
        try {
            int number = Integer.parseInt(attempt);
            if (number <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("올바른 시도 횟수를 입력해주세요.");
        }
    }
}
