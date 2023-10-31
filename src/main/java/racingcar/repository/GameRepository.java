package racingcar.repository;

import racingcar.domain.Game;

import java.util.HashMap;
import java.util.Map;

public class GameRepository {

    private static final Map<Long, Game> games = new HashMap<>();
    private static Long id = 0L;

    public Long save(Game game) {
        Long currentId = id;
        games.put(id, game);
        id += 1;
        return currentId;
    }

    public boolean isEnd(Game game) {
        return game.checkTrialEnd();
    }
}
