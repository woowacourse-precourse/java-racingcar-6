package racingcar.domain.service;

import racingcar.domain.model.Cars;

public class RacingGameFactory {

    private final RandomMoveJudge randomMoveJudicator;

    public RacingGameFactory(RandomMoveJudge randomMoveJudicator) {
        this.randomMoveJudicator = randomMoveJudicator;
    }

    public RacingGame createRacingGame(Cars cars) {
        return new RacingGame(cars, randomMoveJudicator);
    }
}
