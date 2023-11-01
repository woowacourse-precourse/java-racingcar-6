package racingcar.domain.service;

import racingcar.domain.model.Cars;

public class RacingGameFactory {

    private final RandomMoveJudge randomMoveJudge;

    public RacingGameFactory(RandomMoveJudge randomMoveJudge) {
        this.randomMoveJudge = randomMoveJudge;
    }

    public RacingGame createRacingGame(Cars cars) {
        return new RacingGame(cars, randomMoveJudge);
    }
}
