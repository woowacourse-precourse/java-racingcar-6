package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(String inputNames) {

        String[] names = inputNames.split(",");
        cars = Arrays.stream(names)
                .map(name -> new Car(name))
                .toList();
    }

    public void play() {

        cars.stream()
                .forEach(car -> car.play());
    }

    public List<String> findWinners() {
        Car maxPositionCar = findMaxPositionCar();
        return findMaxPositionCarList(maxPositionCar);
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max((car, other) -> car.compareTo(other))
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private List<String> findMaxPositionCarList(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> maxPositionCar.isSamePosition(car))
                .map(Car::getName)
                .toList();
    }
}
