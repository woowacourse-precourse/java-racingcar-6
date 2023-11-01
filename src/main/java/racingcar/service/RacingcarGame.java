package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public class RacingcarGame {
    private static final int CRITERION_FOUR = 4;
    private static final int MOVE_FORWARD_ONCE = 1;

    public List<String> createWinners(List<Car> cars) {
        int max = findMaxMoveForwardCount(cars);
        return cars.stream()
                   .filter(car -> car.getMoveForwardCount() == max)
                   .map(Car::getCarName)
                   .toList();
    }

    private int findMaxMoveForwardCount(List<Car> cars) {
        return cars.stream()
                   .mapToInt(Car::getMoveForwardCount)
                   .max()
                   .orElse(0);
    }

    public void increaseMoveForwardCount(Car car, int randomNumber) {
        if (randomNumber >= CRITERION_FOUR) {
            car.setMoveForwardCount(MOVE_FORWARD_ONCE);
        }
    }
}
