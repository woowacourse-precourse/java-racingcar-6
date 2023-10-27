package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(String carNames) {
        List<String> members = Arrays.asList(carNames.split(","));
        this.cars = members.stream()
                .map(member -> new Car(member, 0))
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
