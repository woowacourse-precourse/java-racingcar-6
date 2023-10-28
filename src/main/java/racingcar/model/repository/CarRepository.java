package racingcar.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.model.domain.Car;

public class CarRepository {

    private Map<Long, Car> cars = new HashMap<>();
    private Long sequence = 0L;

    public void save(Car car) {
        cars.put(++sequence, car);
    }

    public Car findById(Long id) {
        return cars.get(id);
    }

    public List<Car> findAll() {
        return new ArrayList<>(cars.values());
    }
}
