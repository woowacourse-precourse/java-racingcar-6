package racingcar.service;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarResult {

    private final List<Car> cars;

    public CarResult(List<Car> cars) {
        this.cars = cars;
    }

    private int getMaxLength(){
        return cars.stream()
                .map(car -> car.getPosition().length())
                .max(Integer::compareTo)
                .orElse(0);
    }

    private List<String> getMaxPlayer() {
        List<String> maxPlayer = cars.stream()
                .filter(car -> car.getPosition().length() == getMaxLength())
                .map(Car::getName)
                .collect(Collectors.toList());
        return maxPlayer;
    }
}
