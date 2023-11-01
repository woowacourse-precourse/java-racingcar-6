package racingcar.domain;

import java.util.List;
import racingcar.common.RandomUtil;

public class CarManager {

    private final List<Car> cars;
    private int maxMoveForwardCount;

    private CarManager(List<Car> cars) {
        this.cars = cars;
        this.maxMoveForwardCount = 0;
    }

    public static CarManager createFromCars(List<Car> cars) {
        return new CarManager(cars);
    }

    public void orderCarsMoveForward() {
        cars.forEach(car -> {
            int randomNumber = RandomUtil.getRandomNumber();
            car.moveForward(randomNumber);
            updateMaxMoveForwardCount(car.getMoveForwardCount());
        });
    }

    public List<String> orderCarsPrintCurrentCondition() {
        return cars.stream()
                .map(Car::getCurrentCondition)
                .toList();
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
