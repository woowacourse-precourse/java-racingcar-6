package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Match {

    private List<Car> cars = new ArrayList<>();

    public Match(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void start() {
        cars.forEach(Car::moveOrStop);
    }

    public List<Car> getCars() {
        return cars;
    }
}
