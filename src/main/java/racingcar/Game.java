package racingcar;

import java.util.List;
import java.util.NoSuchElementException;

public class Game {
    private final CarStorage carStorage;

    public Game(CarStorage carStorage) {
        this.carStorage = carStorage;
    }

    public List<Car> saveCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        updateStorage(cars);
        return cars;
    }

    public List<Car> playOnce() {
        List<Car> cars = carStorage.getStoredCars();
        List<Car> updatedCars = cars.stream()
                .map(Car::conductAction)
                .toList();
        updateStorage(updatedCars);
        return updatedCars;
    }

    public List<Car> getFinalists() {
        List<Car> cars = carStorage.getStoredCars();
        int winningDisplacement = cars.stream()
                .map(Car::getDisplacement)
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("저장된 자동차가 없습니다"));

        return cars.stream()
                .filter(car -> car.getDisplacement() == winningDisplacement)
                .toList();
    }

    private void updateStorage(List<Car> cars) {
        cars.forEach(carStorage::saveCar);
    }
}
