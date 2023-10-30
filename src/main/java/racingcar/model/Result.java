package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {
    private final List<String> winnerNames;
    private final int winnerDistance;

    public Result(RacingCars cars) {
        this.winnerDistance = findWinnerDistance(cars);
        this.winnerNames = findWinnerNames(cars);
    }

    private int findWinnerDistance(RacingCars cars) {
        int maxDistance = 0;
        for (Car car : cars.getAllCars()) {
            maxDistance = Math.max(car.getCurrentPosition(), maxDistance);
        }
        return maxDistance;
    }

    private List<String> findWinnerNames(RacingCars cars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars.getAllCars()) {
            if (winnerDistance == car.getCurrentPosition()) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    public List<String> getWinnerNames() {
        return Collections.unmodifiableList(winnerNames);
    }

}
