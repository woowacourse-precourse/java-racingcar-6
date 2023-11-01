package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final AttemptCounts attemptCounts;
    private final RacingResult racingResult = new RacingResult();

    private RacingGame(Cars cars, AttemptCounts attemptCounts) {
        this.cars = cars;
        this.attemptCounts = attemptCounts;
    }

    public static RacingGame of(Cars cars, AttemptCounts attemptCounts) {
        return new RacingGame(cars, attemptCounts);
    }

    public RacingRoundResult play() {
        this.cars.move();
        RacingRoundResult racingRoundResult = RacingRoundResult.getRacingRoundResult(this.cars.getCars());
        this.racingResult.addResult(racingRoundResult);
        this.attemptCounts.minusCounts();
        return racingRoundResult;
    }

    public boolean isRemainAttemptCounts() {
        return this.attemptCounts.isRemainAttemptCounts();
    }

    public List<String> getWinners() {
        return this.racingResult.getFinalWinners();
    }
}
