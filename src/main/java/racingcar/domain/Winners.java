package racingcar.domain;

import racingcar.message.ProcessMessage;

import java.util.List;

public class Winners {
    private final List<Car> values;

    public Winners(List<Car> winners) {
        this.values = winners;
    }

    @Override
    public String toString() {
        List<String> names = values.stream().map(Car::getName).toList();
        return String.join(ProcessMessage.COMMA.toString(), names);
    }
}