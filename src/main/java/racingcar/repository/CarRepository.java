package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {
    private static final Map<Long, Car> store = new HashMap<>();
    private static long id = 0L;

    public Car save(Car car) {
        car.setId(id++);
        store.put(car.getId(), car);
        return car;
    }

    public List<Car> findAll(){
        return new ArrayList<>(store.values());
    }

    //for test code
    public long getId(){
        return this.id;
    }
    public Car findById(Long id) {
        return store.get(id);
    }
    public void clearStore(){
        store.clear();
    }
}
