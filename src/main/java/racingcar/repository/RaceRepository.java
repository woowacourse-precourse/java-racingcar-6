package racingcar.repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.model.Race;

public class RaceRepository {
    private Long id = 0L;
    private Map<Long, Race> races = new HashMap<>();

    public Long save(Race race) {
        races.put(id, new Race(race.getCars(), race.getNumRaces()));
        return id++;
    }

    public Race findById(Long id) {
        return races.get(id);
    }

    public Map<Long, Race> findAll() {
        return races;
    }
}