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

    public static Cars from(String carNames) {
        final List<Car> carList = splitCarNames(carNames).stream()
            .map(Car::new)
            .collect(Collectors.toList());
        return new Cars(carList);
    }

    private static List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(","));
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
