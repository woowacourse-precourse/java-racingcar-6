package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.util.CarsValidator;

public class Cars {
    private final List<Car> carList;
    private final static String NULL_VALUE_ERROR_MESSAGE = "자동차 목록이 비어있습니다.";

    public Cars(List<String> carNames) {
        CarsValidator.validateDuplicateName(carNames);
        this.carList = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<String> findWinners() {
        final Car maxPositionCar = findMaxPosition();
        return findSamePositionCar(maxPositionCar);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    private Car findMaxPosition() {
        return carList.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(NULL_VALUE_ERROR_MESSAGE));
    }

    private List<String> findSamePositionCar(Car maxPositionCar) {
        return carList.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(Car::getName)
                .toList();
    }
}
