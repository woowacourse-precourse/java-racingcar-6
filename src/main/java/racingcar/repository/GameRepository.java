package racingcar.repository;

import racingcar.entity.Game;

import java.util.HashMap;
import java.util.Map;

public class GameRepository {
    public GameRepository() {
        this.id = 0l;
    }

    private Map<Long, Game> gameMap = new HashMap<Long, Game>();
    private Long id;
    public Long save(Game saveGame) {
        saveGame.setId(id);
        gameMap.put(id, saveGame);
        return id++;
    }

    public Game findById(Long gameId) {
        return gameMap.get(gameId);
    }
}
