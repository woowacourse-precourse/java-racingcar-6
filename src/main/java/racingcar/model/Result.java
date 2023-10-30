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
        List<String> names = new ArrayList<>();
        for (Car car : cars.getAllCars()) {
            if (winnerDistance == car.getCurrentPosition()) {
                names.add(car.getName());
            }
        }
        return Collections.unmodifiableList(names);
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

}
