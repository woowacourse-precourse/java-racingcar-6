package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Race {

    private List<Car> cars;

    public Race(List<String> carNames) {
        CarNameValidator.validateDuplicateForList(carNames);
        this.cars = new ArrayList<>(generateCars(carNames));
    }

    public List<Car> generateCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public void moveEachCar(int randomNumber) {
        cars.forEach(car -> car.move(randomNumber));
    }

    private List<Car> findWinnerCars() {
        return cars.stream()
                .filter(car -> car.isSameDistanceOrFurtherThan(getMaxDistanceCar()))
                .toList();
    }

    private Car getMaxDistanceCar() {
        Optional<Car> max = cars.stream().max(Comparator.comparingInt(Car::getDistance));
        return cars.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getStatusString() {
        return cars.stream()
                .map(Car::getMovementString)
                .collect(Collectors.joining("\n")) + "\n";
    }

    public String getWinnerString() {
        return findWinnerCars().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}