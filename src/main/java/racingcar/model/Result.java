package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private final List<String> winnerNames;
    private final int winnerDistance;

    public Result(RacingCars cars) {
        this.winnerDistance = findWinnerDistance(cars);
        this.winnerNames = findWinnerNames(cars);
    }

    private int findWinnerDistance(RacingCars cars) {
        return cars.getAllCars().stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(0);
    }

    private List<String> findWinnerNames(RacingCars cars) {
        return cars.getAllCars().stream()
                .filter(car -> winnerDistance == car.getCurrentPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        return Collections.unmodifiableList(winnerNames);
    }

}
