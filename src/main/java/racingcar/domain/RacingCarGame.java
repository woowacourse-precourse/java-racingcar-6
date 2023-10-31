package racingcar.domain;

import java.util.List;

public class RacingCarGame {
    private final Cars cars;
    private PlayCount playCount;

    RacingCarGame(Cars cars, PlayCount playCount) {
        this.cars = cars;
        this.playCount = playCount;
    }

    public static RacingCarGame of(List<String> carNames, int playCount) {
        return new RacingCarGame(Cars.from(carNames), PlayCount.from(playCount));
    }
}
