package racingcar.domain.car.testutil;

import racingcar.domain.car.CarFinished;
import racingcar.domain.car.boxed.CarName;
import racingcar.domain.coordinate.boxed.Coordinate;

public final class CarsTestUtils {

    private CarsTestUtils() {
    }

    public static CarFinished createCarFinished(final String carName) {
        return new CarFinished(new CarName(carName), Coordinate.zero());
    }
}
