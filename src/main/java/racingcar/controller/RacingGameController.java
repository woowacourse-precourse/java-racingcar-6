package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.dto.RacingGameRq;
import racingcar.dto.RacingGameRs;

public class RacingGameController {
    private final RacingGame racingGame;

    public RacingGameController(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public RacingGameRs startGame(RacingGameRq racingGameRq) {
        return racingGame.startGame(racingGameRq);
    }
}
