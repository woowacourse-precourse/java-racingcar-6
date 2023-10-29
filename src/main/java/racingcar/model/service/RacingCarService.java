package racingcar.model.service;

import racingcar.model.domain.Game;

public interface RacingCarService {
    boolean isEnd(Game game);

    void moveCars(Game game);
}
