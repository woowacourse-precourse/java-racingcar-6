package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final Cars cars;
    private final Attempts attempts;
    private final List<String> winnerNames = new ArrayList<>();

    public Winners(Cars cars, Attempts attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    private void countWinners() {
        for (Car car : cars.getCarList()) {
            if (car.getDistance().length() == attempts.getNumber()) {
                winnerNames.add(car.getName());
            }
        }
    }
    public List<String> getWinnerNames() {
        countWinners();
        return this.winnerNames;
    }
}
