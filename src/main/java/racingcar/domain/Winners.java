package racingcar.domain;

import java.util.List;

public class Winners {

    private static final String NOT_FOUNT_CAR = "자동차를 찾을 수 없습니다.";
    private List<Car> winners;

    public Winners(List<Car> cars) {
        winners = findWinners(cars);
    }

    private List<Car> findWinners(List<Car> cars) {
        Car maxPositionCar = findMaxPositionCar(cars);
        return findMaxPositionCarList(maxPositionCar, cars);
    }

    private Car findMaxPositionCar(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUNT_CAR));
    }

    private List<Car> findMaxPositionCarList(Car maxPositionCar, List<Car> cars) {
        return cars.stream()
                .filter(maxPositionCar::isSamePosition)
                .toList();
    }

    public List<Car> getWinners() {
        return winners;
    }
}
