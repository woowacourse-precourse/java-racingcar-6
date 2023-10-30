package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<Car> winners;

    public Result(List<Car> cars) {
        this.winners = ResultGenerator.generate(cars);
    }

    public List<Car> getWinner() {
        return new ArrayList<>(winners);
    }
}
