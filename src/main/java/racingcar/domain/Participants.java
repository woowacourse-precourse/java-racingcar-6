package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {
    private final List<Car> cars;

    public Participants(List<Car> cars) {
        this.cars = cars;
    }

    public static Participants from(List<String> names) {
        return new Participants(names.stream().map(Car::new).toList());
    }

    public List<Car> race() {
        cars.forEach(Car::moveForward);
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        List<Car> candidates = new ArrayList<>(cars);
        Collections.sort(candidates);
        int first = candidates.get(0).getPosition();
        return candidates.stream()
                .filter(car -> car.getPosition() == first)
                .map(Car::getName)
                .toList();
    }
}
