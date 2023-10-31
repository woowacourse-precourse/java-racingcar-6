package racingcar.game;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import racingcar.game.car.Car;
import racingcar.game.storage.CarStorage;

public class Game {
    private static final String NO_CAR_STORED = "저장된 자동차가 없습니다";
    private static final String NO_CAR_INPUT = "입력된 자동차가 없습니다.";
    private static final String DUPLICATE_NAME = "중복된 이름이 존재합니다.";

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
                .orElseThrow(() -> new NoSuchElementException(NO_CAR_STORED));
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

    private void validateListNotEmpty(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(NO_CAR_INPUT);
        }
    }

    private void validateCarDistinct(List<String> cars) {
        long distinctCars = cars.stream()
                .distinct()
                .count();
        if (cars.size() != distinctCars) {
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }
}
