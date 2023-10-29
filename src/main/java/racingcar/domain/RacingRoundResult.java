package racingcar.domain;

import java.util.List;

public class RacingRoundResult {
    public RacingRoundResult(List<String> carMoveHistories) {
        this.carMoveHistories = carMoveHistories;
    }

    public final List<String> carMoveHistories;

    public List<String> getCarMoveHistories() {
        return carMoveHistories;
    }
}
