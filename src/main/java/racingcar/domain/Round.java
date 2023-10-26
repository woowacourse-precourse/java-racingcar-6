package racingcar.domain;

import java.util.List;

public class Round {

    private final List<Car> raceCars;

    public Round(List<Car> raceCars) {
        this.raceCars = raceCars;
    }

    private void validateRaceCars(List<Car> raceCars) {
        raceCars.forEach(car -> {
            if (car == null) {
                throw new IllegalArgumentException("Car cannot be null");
            }
        });
    }
}
