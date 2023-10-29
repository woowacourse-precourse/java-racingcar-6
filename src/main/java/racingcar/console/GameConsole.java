package racingcar.console;

import racingcar.console.game.Game;
import racingcar.console.game.GameList;
import racingcar.console.game.racingcar.RacingCarGame;

import java.util.HashMap;
import java.util.Map;

public class GameConsole {

    GameList target;
    private final Map<GameList, Game> gameMap = new HashMap<>();

    public GameConsole() {
        init();
    }

    private void init() {
        loadAllGameToGameConsole();
        setDefault(GameList.RACING_CAR);
    }

    private void loadAllGameToGameConsole() {
        gameMap.put(GameList.RACING_CAR, new RacingCarGame());
    }

    private void setDefault(GameList defaultTarget) {
        target = defaultTarget;
    }

    public void start() {
        Game targetGame = gameMap.get(target);
        if (targetGame != null)
            targetGame.start();
    }

}
