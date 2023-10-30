package racingcar.repository;

import racingcar.entity.Game;

import java.util.HashMap;
import java.util.Map;

public class GameRepository {
    public GameRepository() {
        this.id = 0l;
    }

    Map<Long, Game> gameMap = new HashMap<Long, Game>();
    Long id;
    public Long save(Long playCount) {
        Game saveGame = new Game(playCount);
        gameMap.put(id, saveGame);
        return id++;
    }
}
