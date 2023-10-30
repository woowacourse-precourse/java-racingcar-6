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

    public List<Car> getCars() {
        return cars;
    }

    public void run() {
        cars.forEach(this::attemptMoving);
    }

    public List<String> judge() {
        final List<Car> winningCars = getWinningCars();
        return winningCars.stream()
            .map(Car::getName)
            .toList();
    }

    private void attemptMoving(Car car) {
        if (checkMoving()) {
            car.move();
        }
    }

    private boolean checkMoving() {
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
