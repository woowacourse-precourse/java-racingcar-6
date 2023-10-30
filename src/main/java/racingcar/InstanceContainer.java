package racingcar;

public class InstanceContainer {
    private final GameHandler gameHandler;

    public InstanceContainer() {
        this.gameHandler = generateGameHandler();
    }

    public GameHandler getGameHandler() {
        return gameHandler;
    }

    private Game generateGame() {
        return new Game();
    }

    private GameHandler generateGameHandler() {
        return new GameHandler(generateGame());
    }
}
