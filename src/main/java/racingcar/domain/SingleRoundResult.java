package racingcar.domain;

import java.util.List;

public class SingleRoundResult {
    public final List<String> carMoveHistories;

    public SingleRoundResult(List<String> carMoveHistories) {
        this.carMoveHistories = carMoveHistories;
    }

    public List<String> getCarMoveHistories() {
        return carMoveHistories;
    }
}
