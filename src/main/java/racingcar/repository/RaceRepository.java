package racingcar.repository;

import racingcar.domain.Race;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceRepository {

    private Long id = 0L;
    private final Map<Long, Race> races = new HashMap<>();

    public Long save(Race race) {
        Long returnId = id;
        races.put(id, race);
        id += 1;
        return returnId;
    }

    public Boolean isEnd(Race race) {
        return race.checkIfTrialEqualTrialNum();
    }

    public Race findById(Long id) {
        return races.get(id);
    }

    public List<Race> findAll() {
        return new ArrayList<>(races.values());
    }
}
