package testutil;

import java.util.List;
import racingcar.domain.Attempts;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;
import racingcar.domain.Cars;

public class TestUtil {

    public static Car createCar(String name, int position) {
        return new Car(new CarName(name), new CarPosition(position));
    }

    public static Cars createCars(Car... car) {
        return new Cars(List.of(car));
    }

    public static Attempts createAttempts(Integer attempts) {
        return new Attempts(attempts);
    }

}
