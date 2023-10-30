package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public void processTurn() {
        carList.forEach(Car::move);
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
        return carList.stream()
            .mapToInt(Car::getMoveCount)
            .max()
            .orElseThrow();
    }

    private List<Car> getWinningCars() {
        final int maxMoveCount = getMaxMoveCount();
        return carList.stream()
            .filter(car -> car.getMoveCount() == maxMoveCount)
            .toList();
    }

}
