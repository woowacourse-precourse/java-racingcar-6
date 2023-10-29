package racingcar.domain.judge;

import java.util.Collections;
import java.util.List;
import racingcar.domain.car.Car;

public class WinnerCars {

    private final List<Car> cars;

    public WinnerCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

}
