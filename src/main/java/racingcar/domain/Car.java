package racingcar.domain;

import static racingcar.generator.RandomNumberGenerator.*;

public class Car {
    private String name;
    private int distances;

    private Car() {}
    public static Car createCarByCarName(String carName) {
        Car car = new Car();
        car.name = carName;
        car.distances = 0;

        return car;
    }

    public void moveForward() {
        if (generateRandomNumbers() >= 4) {
            distances += 1;
        }
    }

}
