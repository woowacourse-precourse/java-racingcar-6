package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {

    private static Integer sequence = 0;
    private static Map<Integer, Car> storage = new HashMap<>();

    public Car save(final String name) {
        Car newCar = new Car(++sequence, name);
        storage.put(sequence, newCar);
        return newCar;
    }

    public void update(final Car car) {
        storage.put(car.getId(), car);
    }

    public Car findById(final Integer id) {
        return storage.get(id);
    }

    public List<Car> findAll() {
        List<Car> carList = new ArrayList<>();
        for(Integer id: storage.keySet()) {
            carList.add(storage.get(id));
        }
        return carList;
    }

    public void deleteAll() {
        storage.clear();
        sequence = 0;
    }

    public Integer getCarCount() {
        return sequence;
    }
}
