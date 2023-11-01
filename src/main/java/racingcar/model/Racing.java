package racingcar.model;

import racingcar.model.winnerstrategy.MaximumForwardStrategy;

public class Racing {
    private final Cars cars;
    private final RacingResult racingResult;
    private final RacingManager racingManager;

    public Racing(Cars cars, int tryCount) {
        this.cars = cars;
        this.racingResult = new RacingResult(cars, new MaximumForwardStrategy());
        this.racingManager = new RacingManager(tryCount);
    }
}
