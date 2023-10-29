package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import racingcar.domain.numberpicker.RandomNumberPicker;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveOnce(RandomNumberPicker randomNumberPicker) {
        this.cars.forEach(car -> car.moveForward(randomNumberPicker));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

}
