package racingcar.game;

import racingcar.util.Assertions;

public class GameManager {
    private final Game game;

    public GameManager(Game game) {
        Assertions.assertNotNull(game);
        this.game = game;
    }

    public void start() {
        boolean startGame = true;

        game.awake();
        while (startGame) {
            startGame = inGameLoop();
        }
        game.cleanup();
    }

    private boolean inGameLoop() {
        if (!game.beforeLoop()) {
            return false;
        }

        boolean continueGame = true;
        while (continueGame) {
            continueGame = game.gameLoop();
        }
        return game.afterLoop();
    }
}