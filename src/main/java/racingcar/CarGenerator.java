package racingcar;

import java.util.List;

public class CarGenerator {
    private final String INVALID_CAR_NAME_LENGTH = "자동차 이름은 5자 이하, 1자 이상만 가능합니다.";

    public Car generate(String carName) {
        validateCarNameLength(carName);
        return new Car(carName);
    }

    public List<Car> generate(List<String> names) {
        return names.stream()
                .map(this::generate)
                .toList();
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5 || carName.length() < 1) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }
}
