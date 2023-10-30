package racingcar.repository;

import java.util.List;
import java.util.Optional;
import racingcar.domain.Racing;
import racingcar.domain.Winners;

public class MemoryRacingRepository implements RacingRepository {
    @Override
    public Racing save(Racing object) {
        return null;
    }

    @Override
    public Optional<Racing> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Racing> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void updateWinners(Winners winners) {

    }
}
