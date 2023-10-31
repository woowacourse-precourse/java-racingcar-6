package racingcar.repository;

import racingcar.domain.Car;
import racingcar.domain.Game;

import java.util.HashMap;
import java.util.Map;

public class GameRepository {

    private int id = 1;
    private Map<Integer, Game> games = new HashMap<>();

    public void save(Game game) {
        games.put(id, game);
        id++;
    }
}
