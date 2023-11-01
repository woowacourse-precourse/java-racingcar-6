package racingcar.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.dto.Car;

public class CarRepository {
    private static final CarRepository instance = new CarRepository();
    private Map<String, Car> carRepository;

    public static CarRepository getInstance() {
        return instance;
    }

    private CarRepository() {
        this.carRepository = new HashMap<>();
    }

    public void saveCar(Car car) {
        carRepository.put(car.name(), car);
    }

    public List<Car> findByAll() {
        List<Car> carList = carRepository.values().stream().toList();
        return carList;
    }

    public Car findByName(String name) {
        return carRepository.get(name);
    }

    public boolean hasName(String name) {
        return carRepository.containsKey(name);
    }

    public void clear() {
        carRepository.clear();
    }
}
