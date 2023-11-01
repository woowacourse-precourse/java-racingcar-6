package racingcar.controller;
import racingcar.view.GameView;

public class GameManager {
    private final GameController gameController = new GameController();

    public void startGame() {
        startRace();
        displayWinners();
    }

    private void startRace() {
        gameController.start();
    }

    private void displayWinners() {
        GameView.printWinners(gameController.getWinners());
    }
}
