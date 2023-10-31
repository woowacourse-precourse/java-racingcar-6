package racingcar.domain;

import java.util.List;

public class Participants {

    private final List<Car> cars;

    public Participants(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        cars.forEach(Car::race);
        cars.forEach(System.out::println);
    }
}
