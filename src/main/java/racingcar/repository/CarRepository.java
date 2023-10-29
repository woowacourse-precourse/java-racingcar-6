package racingcar.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.dto.Car;

public class CarRepository {
    private static final CarRepository instance = new CarRepository();
    private Map<String, Car> cars;

    public static CarRepository getInstance() {
        return instance;
    }

    private CarRepository() {
        this.cars = new HashMap<>();
    }

    public void saveCar(Car car) {
        cars.put(car.name(), car);
    }

    public List<Car> findByAll() {
        List<Car> carList = cars.values().stream().toList();
        return carList;
    }

    public Car findByname(String name) {
        return cars.get(name);
    }

    public int size() {
        return cars.size();
    }
}
