package racingcar;

import java.util.List;

public class CarFactory {
    private final String INVALID_CAR_NAME_LENGTH = "자동차 이름은 5자 이하, 1자 이상만 가능합니다.";
    private final String DUPLICATE_CAR_NAME = "자동차 이름은 중복될 수 없습니다.";

    public Car generate(String carName) {
        validateCarNameLength(carName);
        return new Car(carName);
    }

    public List<Car> generate(List<String> names) {
        List<Car> carList = names.stream()
                .distinct()
                .map(this::generate)
                .toList();

        validateCarDuplication(names.size(), carList.size());
        return carList;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5 || carName.length() < 1) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }

    private void validateCarDuplication(int nameListSize, int carListSize) {
        if (nameListSize != carListSize) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }
}
