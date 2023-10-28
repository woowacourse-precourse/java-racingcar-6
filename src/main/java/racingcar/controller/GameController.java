package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.GameView;

public class GameController {

    private final int retryCount;
    private final Game game;
    private final GameView gameView;

    public GameController(int retryCount, Game game, GameView gameView) {
        this.retryCount = retryCount;
        this.game = game;
        this.gameView = gameView;
    }

    public void playGame() {
        gameView.displayResultMessage();
        tryRoundUntilRetryCount();

        gameView.displayFinalWinner(game.getWinnerNames(game.getWinnerList()));
    }

    private void tryRoundUntilRetryCount() {
        for (int i = 0; i < retryCount; i++) {
            game.moveCar();

            gameView.displayCurrentCarPosition(game.getCurrentParticipantCarPosition());
        }
    }
}