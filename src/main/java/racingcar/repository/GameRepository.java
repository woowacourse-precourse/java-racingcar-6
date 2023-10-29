package racingcar.repository;

import racingcar.entity.Game;

import java.util.HashMap;
import java.util.Map;

public class GameRepository {
    public GameRepository() {
        this.id = 0;
    }

    Map<Integer, Game> gameMap = new HashMap<Integer, Game>();
    Integer id;
    public Game save(Integer playCount) {
        Game saveGame = new Game(playCount);
        gameMap.put(id++, saveGame);
        return saveGame;
    }
}
