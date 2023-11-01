package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = copyList(cars);
    }

    private List<Car> copyList(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    String name = car.getName();
                    int forwardCount = car.getForwardCount();
                    return new Car(name, forwardCount);
                }).toList();
    }

    public List<Car> copyList() {
        return copyList(cars);
    }

    public void race(ForwardStrategy forwardStrategy) {
        cars.forEach(car -> {
            if (forwardStrategy.canMoveForward()) {
                car.moveForward();
            }
        });
    }

    public List<String> findWinners() {
        int maximumForwardCount = findMaximumForwardCount();
        return new ArrayList<>(cars.stream()
                .filter(car -> car.getForwardCount() == maximumForwardCount)
                .map(Car::getName)
                .toList());
    }

    private int findMaximumForwardCount() {
        return cars.stream()
                .map(Car::getForwardCount)
                .max(Integer::compare)
                .orElseThrow();
    }
}
