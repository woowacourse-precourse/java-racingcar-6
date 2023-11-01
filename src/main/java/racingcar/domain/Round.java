package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private List<Car> cars;

    public void generateCars(List<String> carName) {
        List<Car> cars = carName.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.cars = cars;
    }

    public void racing() {
        cars.forEach(car -> car.moveForward(car.generateNumber()));
    }

    public void printRoundResult() {
        cars.forEach(Car::printCurrentPosition);
        System.out.println();
    }
}
