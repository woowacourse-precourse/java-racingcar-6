package racingcar;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public static void checkCarCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("2대 이상의 자동차 이름을 입력해 주세요.");
        }
    }

    public static void checkBlankAndLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException("공백을 입력하지 마세요.");
            }

            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름을 5자 이하로 입력해 주세요.");
            }
        }
    }

    public static void checkDuplication(List<String> carNames) {
        if (carNames.size() > new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException("중복되지 않은 이름을 입력해 주세요.");
        }
    }
}
