package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;

public class MemoryCarRepository implements CarRepository {
    private static Map<Long, Car> store = new HashMap<>();

    @Override
    public void save(Car car) {
        store.put(car.getId(), car);
    }

    @Override
    public Car findById(Long id) {
        return store.get(id);
    }

    public List<Car> findAll() {
        return new ArrayList<>(store.values());
    }
}
