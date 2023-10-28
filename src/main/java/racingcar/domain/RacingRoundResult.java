package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingRoundResult {
    public static final String NOT_AVAILABLE_CAR_LIST_EXCEPTION = "올바르지 않은 자동차 리스트입니다.";
    private final List<Car> cars;

    public RacingRoundResult(List<Car> readOnlyCarList) {
        this.cars = readOnlyCarList;
    }

    public List<Car> getCars() {
        return this.cars.stream()
                .map(car -> new Car(car.getName(), car.getCarEngine(), new Position(car.getPosition())))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(NOT_AVAILABLE_CAR_LIST_EXCEPTION));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
