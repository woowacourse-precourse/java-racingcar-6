package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import racingcar.domain.Race;

public class GameRepository {
    private Long id = 0L;
    private final Map<Long, Race> games = new HashMap<>();

    public Long save(Race game) {
        Long returnId = id;
        games.put(id, game);
        id += 1;
        return returnId;
    }

    public Boolean isEnd(Race game) {
        return game.checkReachTrialNumToTrial();
    }

    public Race findById(Long id) {
        return games.get(id);
    }

    public List<Race> findAll() {
        return new ArrayList<>(games.values());
    }
}
