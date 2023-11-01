package racingcar.domain.race;

import racingcar.domain.race.car.Car;
import racingcar.domain.race.car.Engine;

public class CarFactory {

    private CarFactory() {
    }

    protected static Car newIntanceCar(final String name) {
        return Car.of(name, Engine.newInstance());
    }

}
