package racingcar.repository;

import racingcar.domain.Car;

import java.util.HashMap;
import java.util.Map;

public class CarRepository {

    private int id = 1;
    private Map<Integer, Car> cars = new HashMap<>();

    public void save(Car car) {
        cars.put(id, car);
        id++;
    }
}
