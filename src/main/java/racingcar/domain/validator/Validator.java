package racingcar.domain.validator;

import java.util.List;
import racingcar.option.GameOption;

public class Validator {

    public static void carName(List<String> carName) {
        carNameLength(carName);
        carNameIsEmpty(carName);
    }

    private static void carNameLength(List<String> carName) {
        for (String s : carName) {
            if (s.length() > GameOption.CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            if (s.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
            }
        }
    }

    private static void carNameIsEmpty(List<String> carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
    }

    public static void moveNumber(int moveNumber) {
        if (moveNumber <= 0) {
            throw new IllegalArgumentException("1이상의 숫자를 입력해야합니다.");
        }
    }
}
