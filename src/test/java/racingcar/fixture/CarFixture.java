package racingcar.fixture;

import racingcar.model.Car;

public class CarFixture {

    public static Car createCar(final String name) {
        return Car.from(name);
    }
}
