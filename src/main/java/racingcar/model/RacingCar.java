package racingcar.model;

import java.util.List;

public class RacingCar {

    private final List<Car> cars;
    private final Integer numberOfRetry;

    public RacingCar(List<Car> cars, Integer numberOfRetry) {
        this.cars = cars;
        this.numberOfRetry = numberOfRetry;
    }
}
