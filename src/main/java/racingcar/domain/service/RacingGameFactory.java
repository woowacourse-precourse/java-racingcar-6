package racingcar.domain.service;

import racingcar.domain.model.Cars;

public class RacingGameFactory {

    private final RandomMoveJudicator randomMoveJudicator;

    public RacingGameFactory(RandomMoveJudicator randomMoveJudicator) {
        this.randomMoveJudicator = randomMoveJudicator;
    }

    public RacingGame createRacingGame(Cars cars) {
        return new RacingGame(cars, randomMoveJudicator);
    }
}
