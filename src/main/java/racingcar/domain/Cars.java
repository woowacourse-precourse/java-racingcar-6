package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void move() {
        for (Car car : cars) {
            car.go();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
