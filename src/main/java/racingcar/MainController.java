package racingcar;

import java.util.List;

public class MainController {

    private final InputController inputController = new InputController();
    private Game game;

    public void initGame() {
        List<String> carNames = inputController.getCarNames();
        int trialNumber = inputController.getTrialNumber();

        game = new Game(carNames, trialNumber);
    }

    private void playGame() {
        game.play();
    }
}