package racingcar.domain;

import java.util.List;

public class CarManager {

    private final List<Car> cars;
    private int maxMoveForwardCount;

    private CarManager(List<Car> cars) {
        this.cars = cars;
        this.maxMoveForwardCount = 0;
    }

    public static CarManager createFromInputCarNames(String inputCarNames) {
        List<String> carNames = NameSeparator.separateNamesByComma(inputCarNames);
        List<Car> cars = carNames.stream().map(Car::createFromName).toList();
        return new CarManager(cars);
    }

    public void orderCarsMoveForward() {
        cars.forEach(car -> {
            car.moveForward();
            updateMaxMoveForwardCount(car.getMoveForwardCount());
        });
    }

    private void updateMaxMoveForwardCount(int count) {
        this.maxMoveForwardCount = Math.max(count, this.maxMoveForwardCount);
    }

    public List<Car> getWinners() {
        return cars.stream()
                .filter(car -> car.getMoveForwardCount() == maxMoveForwardCount)
                .toList();
    }

}
