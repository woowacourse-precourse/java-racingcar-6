package service;

import static service.RandomNumber.getRandomNumber;

import java.util.Collections;
import java.util.List;

public record Cars(List<Car> car) {

    public void go() {
        car.forEach(car -> {
            car.go(getRandomNumber());
        });
    }

    public List<String> determineWinner() {
        List<String> name;
        name = car.stream()
                .filter(c -> c.getDistance() == getMaxDistance())
                .map(Car::getName)
                .toList();
        return name;
    }

    public int getMaxDistance() {
        List<Integer> distance;
        distance = car.stream().map(Car::getDistance).toList();
        return Collections.max(distance);
    }

}
