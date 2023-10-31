package racingcar.service;

import racingcar.domain.RacingGame;

public interface RacingGameService {

    RacingGame save(RacingGame racingGame);

    RacingGame generateRacing(String carNames, String tryCount);

    void decideRandomMoveCondition(RacingGame racingGame);
}
