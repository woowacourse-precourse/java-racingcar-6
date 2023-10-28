package racingcar.domain;

import java.util.List;

public class Participants {
    private final List<Car> cars;

    public Participants(List<String> names) {
        cars = names.stream()
                .map(Car::new)
                .toList();
    }
}
