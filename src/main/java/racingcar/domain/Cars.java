package racingcar.domain;

import racingcar.utils.Validator;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> names) {
        Validator.validate(names);
        this.cars = createCars(names);
    }

    private List<Car> createCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void run() {
        List<Car> movedCars = cars.stream()
                .map(Car::move)
                .collect(Collectors.toList());

        setCars(movedCars);
    }

    public List<String> findWinners() {
        final Car maxDistanceCar = findMaxDistanceCar();
        return findSameDistanceCars(maxDistanceCar);
    }

    private Car findMaxDistanceCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    private List<String> findSameDistanceCars(Car maxDistanceCar) {
        return cars.stream()
                .filter(maxDistanceCar::isSameDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
