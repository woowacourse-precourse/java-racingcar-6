package racingcar.service;

import racingcar.domain.RacingGame;

public interface RacingGameService {

    RacingGame save(RacingGame racingGame);
    void racing(RacingGame racingGame);

    RacingGame generateRacing(String carNames, String tryCount);
}
