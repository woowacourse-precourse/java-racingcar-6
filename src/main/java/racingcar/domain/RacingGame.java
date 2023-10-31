package racingcar.domain;

import java.util.List;

public class RacingGame {
    private List<Car> carList;
    private final Referee referee;
    private final int round;

    public RacingGame(List<Car> carList, Referee referee, int round) {
        this.carList = carList;
        this.referee = referee;
        this.round = round;
    }
}
