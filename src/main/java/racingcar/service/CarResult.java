package racingcar.service;

import racingcar.model.Car;
import java.util.List;
import java.util.stream.Collectors;

public class CarResult {

    private final List<Car> cars;
    public CarResult(List<Car> cars) {
        this.cars = cars;
    }

    private String getMaxPosition(){
        return cars.stream()
                .map(car -> car.getPosition())
                .max(String::compareTo)
                .orElse("");
    }

    public List<String> getMaxPlayer() {
        List<String> maxPlayer = cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
        return maxPlayer;
    }
}
