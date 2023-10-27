package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public record Cars(List<Car> cars) {
    private static final String EMPTY_CARS_ERROR_MESSAGE = "차량은 한 대 이상이어야 합니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "차량 이름이 중복되었습니다.";

    public Cars(List<Car> cars) {
        this.cars = cars;
        validate();
    }

    @Override
    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    private Set<String> getCarNameSet() {
        List<String> carNames = cars.stream().map(Car::getName).toList();
        return Set.copyOf(carNames);
    }

    private void validateCarsAmount() {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CARS_ERROR_MESSAGE);
        }
    }

    private void validateDuplicatedCarNames() {
        Set<String> carNameSet = getCarNameSet();
        if (carNameSet.size() != cars.size()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validate() {
        validateCarsAmount();
        validateDuplicatedCarNames();
    }

    public void moveCars() {
        cars.forEach(Car::attemptToMove);
    }

}
