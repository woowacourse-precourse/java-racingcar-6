package racingcar.domain;

import racingcar.utils.Parser;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String string) {
        List<String> names = Parser.stringToList(string);
        this.cars = createCars(names);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> createCars(List<String> names) {
        List<Car> cars = names.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());

        return cars;
    }

    public Cars run() {
        List<Car> newCars = cars.stream()
                .map(car -> car.move())
                .collect(Collectors.toList());

        return new Cars(newCars);
    }

    public List<String> findWinners() {
        final Car maxDistanceCar = findMaxDistanceCar();
        return findSameDistanceCars(maxDistanceCar);
    }

    private Car findMaxDistanceCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new NoSuchElementException());
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
}
