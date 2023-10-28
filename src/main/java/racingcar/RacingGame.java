package racingcar;

import java.util.List;

public class RacingGame {
    public RacingGame() {
    }

    public ResultMessage printCarName(List<Car> cars) {
        return new ResultMessage(cars);
    }
}
