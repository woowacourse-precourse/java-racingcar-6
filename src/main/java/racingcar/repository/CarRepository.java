package racingcar.repository;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {
    private static final Map<Long, Car> store = new HashMap<>();
    private static long id = 0L;

    public void save(String carName) {
        long newId = ++id;
        Car car = new Car(newId, carName, 0);
        store.put(newId, car);
    }

    public int size() {
        return store.size();
    }

    public List<Car> findAll() {
        return new ArrayList<>(store.values());
    }

    public void updateIncreasedCarPosition(Car car) {
        car.increaseCarPosition();
        store.put(car.getId(), car);
    }
}
