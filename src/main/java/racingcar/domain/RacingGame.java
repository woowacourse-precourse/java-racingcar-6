package racingcar.domain;

import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private final Referee referee;
    private final int round;

    public RacingGame(List<Car> carList, Referee referee, int round) {
        this.cars = carList;
        this.referee = referee;
        this.round = round;
    }
}
