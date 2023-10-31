package repository;

import domain.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRepository {
    private long id = 0L;
    private final Map<Long, Game> gameList = new HashMap<>();

    public Long save(Game game) {
        Long returnId = id;
        gameList.put(id, game);
        id += 1;
        return returnId;
    }

    public Boolean isEnd(Game game) {
        return game.checkTrial();
    }

    public Game findById(Long id) {
        return gameList.get(id);
    }

    public List<Game> findAll() {
        return new ArrayList<>(gameList.values());
    }
}
