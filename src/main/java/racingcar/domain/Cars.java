package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final String EMPTY_CARS_ERROR_MESSAGE = "차량은 한 대 이상이어야 합니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "차량 이름이 중복되었습니다.";


    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
        validate();
    }

    private void validateCarsAmount() {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CARS_ERROR_MESSAGE);
        }
    }

    private void validateDuplicatedCarNames() {
        Set<String> carNames = new HashSet<>();
        for (Car car : cars) {
            if (carNames.contains(car.getName())) {
                throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
            }
            carNames.add(car.getName());
        }

    }

    private void validate() {
        validateCarsAmount();
        validateDuplicatedCarNames();
    }
}
