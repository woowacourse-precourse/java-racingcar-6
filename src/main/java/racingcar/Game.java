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

    public List<Car> getWinners() {
        Car leadingCar = carStorage.getLeadingCar()
                .orElseThrow(() -> new NoSuchElementException("저장된 자동차가 없습니다"));
        return carStorage.getWinners(leadingCar);
    }

    private void updateStorage(List<Car> cars) {
        cars.forEach(carStorage::saveCar);
    }

    public GameProgress playOnce() {
        List<Car> cars = carStorage.getStoredCars();
        List<Car> updatedCars = cars.stream()
                .map(Car::conductAction)
                .toList();
        updateStorage(updatedCars);
        return GameProgress.of(updatedCars);
    }
}
