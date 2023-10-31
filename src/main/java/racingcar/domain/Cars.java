package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.util.CarsValidator;

public class Cars {
    private static final String NO_CARS_IN_LIST_ERROR = "자동차 목록이 비어있습니다.";
    private final List<Car> carList;

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
                .orElseThrow(() -> new IllegalArgumentException(NO_CARS_IN_LIST_ERROR));
    }

    private List<String> findSamePositionCar(Car maxPositionCar) {
        return carList.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(Car::getName)
                .toList();
    }
}
