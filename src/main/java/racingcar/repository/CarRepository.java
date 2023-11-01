package racingcar.repository;

import racingcar.model.Car;

import java.util.LinkedList;
import java.util.List;

public class CarRepository {

    private final List<Car> cars = new LinkedList<>();

    public void saveAll(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public List<Car> getAll() {
        return cars;
    }
}
