package racingcar.domain.car;

import racingcar.domain.policy.DriveRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> values;

    public Cars(List<Car> values) {
        this.values = new ArrayList<>(values);
    }

    public void move(DriveRule driveRule) {
        values.forEach(car -> car.move(driveRule));
    }

    public String printPosition() {
        return values.stream()
                .map(Car::printPosition)
                .collect(Collectors.joining());
    }

    public String getWinner() {
        return values.stream()
                .map(car -> car.getWinner(values))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(", "));
    }
}