package racingcar;

import java.util.List;

public class MainController {

    private final InputController inputController = new InputController();
    private Game game;
    private TrialNumber trialNumber;

    public void initGame() {
        List<String> carNames = inputController.getCarNames();
        int trialNumberInput = inputController.getTrialNumber();
        game = new Game(carNames);
        trialNumber = new TrialNumber(trialNumberInput);
    }

    public void playGame() {
        RoundResult roundResult = game.race();
    }
}