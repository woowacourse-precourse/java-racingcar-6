package racingcar.model.race;

import racingcar.model.car.Cars;
import racingcar.model.race.result.RaceResult;

public class Race {

    private final Cars cars;
    private final GameCount gameCount;
    private final RaceResult result;

    private Race(final Cars cars, final GameCount gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
        result = RaceResult.create();
    }

    public static Race of(final Cars cars, final GameCount gameCount) {
        return new Race(cars, gameCount);
    }

    public void start() {
        while (!gameCount.isGameOver()) {
            gameCount.run();
            cars.run();
            result.captureCars(cars);
        }
    }

    public RaceResult getResult() {
        return result;
    }
}
