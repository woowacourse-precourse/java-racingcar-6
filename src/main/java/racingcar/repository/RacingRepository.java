package racingcar.repository;

import racingcar.domain.Racing;
import racingcar.domain.Winners;

public interface RacingRepository extends Repository {

    Racing updateWinners(Long racingId, Winners winners);
}
