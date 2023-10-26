package racingcar.entity.car;

import java.util.HashSet;
import java.util.List;

import static racingcar.constants.ErrorConstants.DUPLICATE_NAME_ERROR_MESSAGE;

public class RaceCars {
    private final List<Car> cars;

    public RaceCars(List<Car> cars) {
        this.cars = cars;
    }


}
