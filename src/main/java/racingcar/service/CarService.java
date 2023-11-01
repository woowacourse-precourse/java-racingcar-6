package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarService {

    private static final ArrayList<Car> cars = new ArrayList<>();

    public void saveCar(Car car) {
        cars.add(car);
    }

    public List<Car> findCars() {
        return new ArrayList<>(cars);
    }
}