package racingcar.Repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.Domain.Game;

public class GameRepository {
    private Long id = 0L;
    private final Map<Long, Game> gameStorage = new HashMap<>();

    public Long saveGameProcess(Game game) {
        gameStorage.put(id, game);
        return id++;
    }

    public Boolean gameIsFinished(Game game) {
        return game.finishTotalTryCountCheck();
    }

}
