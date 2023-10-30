package racingcar;

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
