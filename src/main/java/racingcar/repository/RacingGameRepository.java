package racingcar.repository;

import racingcar.domain.RacingGame;
import racingcar.domain.Winners;

public interface RacingGameRepository extends Repository {

    RacingGame updateWinners(Long racingId, Winners winners);
}
