package racingcar.model;

import static racingcar.Constants.MAX_RANDOM_NUMBER;
import static racingcar.Constants.MIN_RANDOM_NUMBER;
import static racingcar.Constants.MOVE_CONDITION;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {

    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> processTurn() {
        cars.forEach(this::attemptMoving);
        return cars;
    }

    public List<String> judge() {
        final List<Car> winningCars = getWinningCars();
        return winningCars.stream()
            .map(Car::getName)
            .toList();
    }

    private void attemptMoving(Car car) {
        if (canMoving()) {
            car.move();
        }
    }

    private boolean canMoving() {
        final int random = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return random >= MOVE_CONDITION;
    }

    private int getMaxMoveCount() {
        return cars.stream()
            .mapToInt(Car::getMoveCount)
            .max()
            .orElseThrow();
    }

    private List<Car> getWinningCars() {
        final int maxMoveCount = getMaxMoveCount();
        return cars.stream()
            .filter(car -> car.getMoveCount() == maxMoveCount)
            .toList();
    }

}
