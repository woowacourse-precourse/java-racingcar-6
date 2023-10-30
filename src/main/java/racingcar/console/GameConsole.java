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
        loadAllGame();
        setDefaultGame(GameList.RACING_CAR);
    }

    private void loadAllGame() {
        gameMap.put(GameList.RACING_CAR, new RacingCarGame());
    }

    private void setDefaultGame(GameList defaultTarget) {
        target = defaultTarget;
    }

    public void start() {
        Game targetGame = gameMap.get(target);
        if (targetGame != null)
            targetGame.start();
    }

}
