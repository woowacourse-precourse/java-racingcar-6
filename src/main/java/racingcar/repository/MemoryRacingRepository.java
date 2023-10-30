package racingcar.repository;

import racingcar.domain.Racing;
import racingcar.domain.Winners;

public class MemoryRacingRepository extends MemoryRepository<Racing> implements RacingRepository {

    @Override
    public void updateWinners(Winners winners) {

    }
}
