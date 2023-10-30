package racingcar;

import java.util.List;

public class Validator {
    public static void validateBlank(String carName) {
        String ridBlank = carName.replace(" ", "");
        if (ridBlank.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 공백을 입력 할 수 없습니다.");
        }

    }

    public static void validateLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 최대 5자까지 입력 가능합니다.");
        }
    }

    public static void validateCarName(List<String> carNames) {
        carNames.forEach(carName -> {
            validateBlank(carName);
            validateLength(carName);
        });
    }

}
