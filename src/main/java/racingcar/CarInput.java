package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarInput {
    private final List<String> carNames;
    private CarInput(List<String> carNames) {
        this.carNames = carNames;
    }
    public static CarInput of(String input) {
        List<String> carNames = Arrays.stream(input.split(GameConfig.DELIMITER)).toList();
        validate(carNames);
        return new CarInput(carNames);
    }

    private static void validate(List<String> carNames) {
        for (String name : carNames) {
            checkLength(name);
        }
    }

    private static void checkLength(String carName) {
        if (carName.length() > GameConfig.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
