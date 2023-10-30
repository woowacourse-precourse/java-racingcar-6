package racingcar.instance;

import racingcar.commander.GameHandler;
import racingcar.game.Game;
import racingcar.game.storage.CarStorage;

public class InstanceContainer {
    private final GameHandler gameHandler;

    public InstanceContainer() {
        this.gameHandler = generateGameHandler();
    }

    public GameHandler getGameHandler() {
        return gameHandler;
    }

    private CarStorage generateCarStorage() {
        return new CarStorage();
    }

    private Game generateGame() {
        return new Game(generateCarStorage());
    }

    private GameHandler generateGameHandler() {
        return new GameHandler(generateGame());
    }
}
