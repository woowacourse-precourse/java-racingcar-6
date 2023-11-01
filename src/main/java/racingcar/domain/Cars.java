package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.util.NumberGenerator;

public class Cars {

    private static final int STARTING_POSITION = 0;

    private final List<Car> cars;

    private Cars(List<String> names) {
        this.cars = createCars(names);
    }

    public static Cars of(List<String> names) {
        return new Cars(names);
    }

    private List<Car> createCars(List<String> names) {
        return names.stream()
                .map(name -> Car.of(name, STARTING_POSITION))
                .toList();
    }

    public List<Car> race(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
        return get();
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinnerNames() {
        Car car = getMaxPositionCar();
        return findSamePositionCarNames(car);
    }

    private Car getMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .get();
    }

    private List<String> findSamePositionCarNames(Car car) {
        return cars.stream()
                .filter(car::isSamePosition)
                .map(Car::getName)
                .map(Name::toString)
                .toList();
    }
}
