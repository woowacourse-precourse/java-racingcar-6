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
        addRacingCarGameToConsole();
        setDefaultAsRacingCarGame();
    }

    private void addRacingCarGameToConsole() {
        gameMap.put(GameList.RACING_CAR, new RacingCarGame());
    }

    private void setDefaultAsRacingCarGame() {
        target = GameList.RACING_CAR;
    }

    public void start() {
        Game targetGame = gameMap.get(target);
        if (targetGame != null)
            targetGame.start();
    }

}
