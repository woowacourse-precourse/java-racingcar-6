package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<Car> carList;
    private final Referee referee;

    public RacingGame() {
        this.carList = new ArrayList<>();
    }
}
