package racingcar.domain;

import java.util.ArrayList;
import racingcar.car.Car;

public class Racing {
    private final ArrayList<Car> cars;

    public Racing(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void start() {
        for (Car car : cars) {
            car.move();
        }
    }
}
