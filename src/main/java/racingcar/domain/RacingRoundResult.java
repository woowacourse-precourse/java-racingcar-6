package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingRoundResult {
    private static final String NOT_AVAILABLE_CAR_LIST_EXCEPTION = "올바르지 않은 자동차 리스트입니다.";
    private final List<Car> cars;

    private RacingRoundResult(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingRoundResult getRacingRoundResult(List<Car> cars) {
        return new RacingRoundResult(cars);
    }

    public List<Car> getCars() {
        return this.cars.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return getSamePosition(maxPosition);
    }

    private List<String> getSamePosition(int maxPosition) {
        return this.cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return this.cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(NOT_AVAILABLE_CAR_LIST_EXCEPTION));
    }
}
