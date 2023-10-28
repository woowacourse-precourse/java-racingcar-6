package racingcar.fixture;

import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.model.Position;

public class CarFixture {

    public static Car createCar(final String name, final int position) {
        return new Car(new Name(name), new Position(position));
    }
}
