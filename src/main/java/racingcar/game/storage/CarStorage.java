package racingcar.game.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import racingcar.game.car.Car;

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

    public Optional<Car> getLeadingCar() {
        return cars.values()
                .stream()
                .max(Car::compareTo);
    }

    public List<Car> getWinners(Car leadingCar) {
        return cars.values()
                .stream()
                .filter(car -> car.isTieWith(leadingCar))
                .toList();
    }
}
