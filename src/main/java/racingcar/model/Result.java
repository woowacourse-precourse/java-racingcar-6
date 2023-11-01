package racingcar.model;

import java.util.List;

public class Result {
    private final List<String> winnerNames;
    private final int winnerDistance;

    public Result(RacingCars cars) {
        this.winnerDistance = findWinnerDistance(cars);
    }

    private int findWinnerDistance(RacingCars cars) {
        return cars.getAllCars().stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(0);
    }
}
