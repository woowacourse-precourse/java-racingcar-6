package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.GameView;

public class GameController {

    private final int retryCount;
    private final Game game;

    public GameController(int retryCount, Game game) {
        this.retryCount = retryCount;
        this.game = game;
    }

    public void playGame() {
        GameView.displayResultMessage();
        tryRoundUntilRetryCount();

        GameView.displayFinalWinner(game.getWinnerNames(game.getWinnerList()));
    }

    private void tryRoundUntilRetryCount() {
        for (int i = 0; i < retryCount; i++) {
            game.moveCar();

            GameView.displayCurrentCarPosition(game.getCurrentParticipantCarPosition());
        }
    }
}