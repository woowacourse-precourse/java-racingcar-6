package racingcar.repository;

import racingcar.constant.GameConstantValue;
import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepositoryImpl implements CarRepository {

    private static Map<Long, Car> store = new HashMap<>();

    @Override
    public void create(Car car) {
        store.put(car.getId(), car);
    }

    @Override
    public void update(Long carId) {
        Car car = store.get(carId);
        car.setDistance(car.getDistance() + GameConstantValue.INCREASE_DISTANCE);
    }

    @Override
    public Car findById(Long carId) {
        return store.get(carId);
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(store.values());
    }
}
