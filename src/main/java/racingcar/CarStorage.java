package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarStorage {
    private final Map<String, Car> cars;

    public CarStorage() {
        this.cars = new HashMap<>();
    }

    public Car saveCar(Car car) {
        cars.put(car.displayName(), car);
        return car;
    }

    public List<Car> getStoredCars() {
        return cars.values()
                .stream()
                .toList();
    }
}
