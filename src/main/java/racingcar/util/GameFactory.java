package racingcar.util;

import racingcar.Game;
import racingcar.Type.GameType;

import java.util.List;

public class GameFactory {

    private final List<Game> gameList;

    public GameFactory(List<Game> gameList) {
        this.gameList = gameList;
    }

    public Game getGame(GameType gameType) {
        return gameList.stream()
                .filter(v -> v.support(gameType))
                .findFirst()
                .orElseThrow();
    }
}
