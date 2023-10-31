package racingcar.domain.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import racingcar.domain.entity.Car;

public class CarRepository {
    private static final Map<String, Car> store = new HashMap<>();

    public Optional<Car> save(Car car) {
        store.put(car.getCarName(), car);
        return Optional.ofNullable(car);
    }

    public Optional<Car> findByCarName(String carName) {
        Car car = store.get(carName);
        return Optional.ofNullable(car);
    }

    public List<Car> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Car car) {
        store.put(car.getCarName(), car);
    }

    public void clearAll() {
        store.clear();
    }
}
