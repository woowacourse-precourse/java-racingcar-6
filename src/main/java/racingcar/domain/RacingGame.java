package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RaceCount raceCount;

    public RacingGame(List<Car> cars, int raceCount) {
        this.cars = new Cars(cars);
        this.raceCount = new RaceCount(raceCount);
    }

    public void race(NumberGenerator numberGenerator) {
        cars.makeMoveOrStop(numberGenerator);

        raceCount.decrease();
    }

    public boolean isGameEnd() {
        return raceCount.isLastCount();
    }
}
