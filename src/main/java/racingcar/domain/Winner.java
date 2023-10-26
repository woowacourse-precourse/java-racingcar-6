package racingcar.domain;

import java.util.List;

public class Winner {

    private final List<Car> value;

    public Winner(List<Car> winner) {
        this.value = winner;
    }

    public List<Car> getValue() {
        return value;
    }
}
