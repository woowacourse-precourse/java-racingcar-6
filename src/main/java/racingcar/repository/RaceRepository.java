package racingcar.repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.model.Race;

public class RaceRepository {
    private Long id = 0L;
    private Map<Long, Race> games = new HashMap<>();

    public Long save(Race race) {
        games.put(id, race);
        return id++;
    }

    public Race findById(Long id) {
        return games.get(id);
    }

    public Map<Long, Race> findAll() {
        return games;
    }
}
