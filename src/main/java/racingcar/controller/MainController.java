package racingcar.controller;

import java.util.List;
import racingcar.Game;
import racingcar.RoundResult;
import racingcar.domain.TrialNumber;
import racingcar.view.OutputView;

public class MainController {

    private final InputController inputController;
    private final OutputView outputView;
    private Game game;
    private TrialNumber trialNumber;

    public MainController(InputController inputController, OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {
        initGame();
        playGame();
    }

    private void initGame() {
        List<String> carNames = inputController.getCarNames();
        int trialNumberInput = inputController.getTrialNumber();
        game = new Game(carNames);
        trialNumber = new TrialNumber(trialNumberInput);
    }

    private void playGame() {
        outputView.printResultMessage();
        do {
            playSingleTrial();
        } while (!trialNumber.isZero());

        outputView.printWinners(game.getWinners());
    }

    private void playSingleTrial() {
        RoundResult roundResult = game.race();
        outputView.printRoundResult(roundResult);
        trialNumber.subtractOne();
    }
}