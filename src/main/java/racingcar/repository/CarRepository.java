package racingcar.repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.model.Car;

public class CarRepository {
    private Long id = 0L;
    private Map<Long, Car> cars = new HashMap<>();

    public Long save(Car car) {
        cars.put(id, car);
        return id++;
    }

    public Car findById(Long id) {
        return cars.get(id);
    }

    public Map<Long, Car> findAll() {
        return cars;
    }
}
