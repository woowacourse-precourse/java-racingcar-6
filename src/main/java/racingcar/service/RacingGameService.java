package racingcar.service;

import racingcar.domain.racing.RacingGame;

public interface RacingGameService {

    RacingGame save(RacingGame racingGame);

    RacingGame generateRacing(String carNames, String tryCount);

    void decideRandomMoveCondition(RacingGame racingGame);

    void calculateWinners(RacingGame racingGame);
}
