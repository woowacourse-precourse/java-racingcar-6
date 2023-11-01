package racingcar.domain.car;

import java.util.Arrays;

public class Cars {

    private Car[] cars;

    public void createCars(String[] drivers) {
        cars = Arrays.stream(drivers)
            .map(Car::new)
            .toArray(Car[]::new);
    }

    public void moveCars() {
        Arrays.stream(cars).forEach(Car::recordDistance);
    }

    public Car[] getCars() {
        return cars;
    }
}