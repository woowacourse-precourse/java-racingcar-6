package racingcar.module.dao;

import java.util.HashMap;
import java.util.Map;
import racingcar.module.domain.Game;

public class GameRepository {
    private static Long id = 0L;
    private static final Map<Long, Game> store = new HashMap<>();

    private static final GameRepository instance = new GameRepository();

    private GameRepository() {
    }

    public static GameRepository getInstance() {
        return instance;
    }

    public Game save(Game game) {
        game.setId(++id);
        store.put(game.getId(), game);
        return game;
    }
}
