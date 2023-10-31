package racingcar;

import java.util.List;

public class InputValidator {

    public static void validateCarNames(List<String> names) {
        for (String name : names) {
            if (name.isEmpty() || name.length() >= 5) {
                throw new IllegalArgumentException("자동차 이름은 비어있지 않고, 5자 이하이어야 합니다.");
            }
        }
    }

    public static void validateNumberOfRounds(int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
