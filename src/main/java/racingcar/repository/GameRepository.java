package racingcar.repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.Game;

public class GameRepository {
    private Long id = 0L;
    private Map<Long, Game> games = new HashMap<>();

    public Long save(Game game) {
        games.put(id, game);
        return id++;
    }

    public Game findById(Long id) {
        return games.get(id);
    }

    public Map<Long, Game> findAll() {
        return games;
    }
}
