package racingcar.domain.collection;

import racingcar.domain.RacingCar;
import racingcar.domain.interfaces.Cars;

import java.util.Collections;
import java.util.List;

public class RacingCars implements Cars {

    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
