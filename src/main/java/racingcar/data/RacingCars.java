package racingcar.data;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars() {
        this.cars = new ArrayList<>();
    }

    public Car createCar(String name) {
        Car newCar = new Car(new CarName(name));
        cars.add(newCar);
        return newCar;
    }
}
