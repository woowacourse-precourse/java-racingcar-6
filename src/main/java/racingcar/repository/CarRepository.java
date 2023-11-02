package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {

    private static final Map<Long, Car> cars = new HashMap<>();
    private static Long id = 0L;

    public void save(Car car) {
        cars.put(id, car);
        id += 1;
    }

    public List<Car> findAll() {
        return new ArrayList<>(cars.values());
    }
}
