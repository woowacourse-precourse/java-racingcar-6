package racingcar.model;

import java.util.List;

public class Racing {

    private final List<Car> cars;

    private Racing(List<Car> cars) {
        this.cars = cars;
    }

    public static Racing makeRacingByCarNames(List<String> carNames) {
        return new Racing(carNames.stream().map(Car::new).toList());
    }

    public void tryCarsMoveForward() {
        cars.forEach(car -> car.randomGoForward());
    }

    public List<String> getWinningCarNames() {
        Integer maxCount = getMaxMoveCount();
        return cars.stream().filter(car -> car.getMoveCount() == maxCount).map(Car::getName)
            .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    private Integer getMaxMoveCount() {
        return cars.stream().mapToInt(Car::getMoveCount).max().getAsInt();
    }
}
