package racingcar.domain;

import racingcar.message.ProcessMessage;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> values;

    public Winners(List<Car> winners) {
        this.values = winners;
    }

    @Override
    public String toString() {
        return values
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining((ProcessMessage.COMMA.toString())));
    }
}
