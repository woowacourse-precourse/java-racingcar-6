package racingcar.fixture;

import java.util.List;
import racingcar.model.Cars;

public class CarsFixture {

    public static Cars createCars(final List<String> carNames) {
        return Cars.from(carNames);
    }
}
