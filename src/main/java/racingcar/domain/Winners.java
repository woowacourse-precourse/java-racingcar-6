package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        return winners.stream().map(Car::getName).collect(Collectors.joining(", "));
    }
}
