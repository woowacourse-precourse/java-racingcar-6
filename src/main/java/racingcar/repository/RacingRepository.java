package racingcar.repository;

import racingcar.domain.Winners;

public interface RacingRepository  extends Repository {

    void updateWinners(Winners winners);
}
