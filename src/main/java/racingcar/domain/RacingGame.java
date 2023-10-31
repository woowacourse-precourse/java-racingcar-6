package racingcar.domain;

import racingcar.view.View;

public class RacingGame {
    private final GameManager gameManager;

    private RacingGame(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public static RacingGame create() {
        return new RacingGame(new GameManager(new RandomNumberGenerator(), new RacingGameConsole()));
    }

    public void run() {
        View.printStartMessage();
        gameManager.readCarNames();

        View.printEnterAttemptCountMessage();
        gameManager.readAttemptCount();

        gameManager.startGame();
        View.printGameProcess(gameManager.getGameLog());
        View.printGameResult(gameManager.getGameWinner());
    }
}
