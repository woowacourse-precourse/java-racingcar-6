package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();
    private final static int maxCarCount = 100;

    public void save(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
