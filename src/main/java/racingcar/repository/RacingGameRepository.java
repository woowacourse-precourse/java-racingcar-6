package racingcar.repository;

import racingcar.domain.RacingGame;

public interface RacingGameRepository {
    void save(RacingGame racingGame);

    RacingGame findById(Long Id);

}
