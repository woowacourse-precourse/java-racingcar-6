package racingcar.fixture;

import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.model.Position;

public class CarFixture {

    public static Car createCar(final String name) {
        return new Car(new Name(name), Position.createDefault());
    }
}
