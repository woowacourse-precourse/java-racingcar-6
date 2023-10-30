package racingcar;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class Game {
    private final CarStorage carStorage;

    public Game(CarStorage carStorage) {
        this.carStorage = carStorage;
    }

    public List<Car> setUp(List<String> cars) {
        validateCars(cars);
        return saveCars(cars);
    }

    public List<GameProgress> playAll(int trials) {
        return IntStream.range(0, trials)
                .mapToObj(trial -> playOnce())
                .toList();
    }

    public List<Car> getWinners() {
        Car leadingCar = carStorage.getLeadingCar()
                .orElseThrow(() -> new NoSuchElementException("저장된 자동차가 없습니다"));
        return carStorage.getWinners(leadingCar);
    }

    private List<Car> saveCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        updateStorage(cars);
        return cars;
    }

    private void updateStorage(List<Car> cars) {
        cars.forEach(carStorage::saveCar);
    }

    private GameProgress playOnce() {
        List<Car> cars = carStorage.getStoredCars();
        List<Car> updatedCars = cars.stream()
                .map(Car::conductAction)
                .toList();
        updateStorage(updatedCars);
        return GameProgress.of(updatedCars);
    }

    public void validateCars(List<String> cars) {
        validateListNotEmpty(cars);
        validateCarDistinct(cars);
    }

    private static void validateListNotEmpty(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("입력된 자동차가 없습니다.");
        }
    }

    private static void validateCarDistinct(List<String> cars) {
        long distinctCars = cars.stream()
                .distinct()
                .count();
        if (cars.size() != distinctCars) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }
}
