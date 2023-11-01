package racingcar;

import java.util.List;

public class MainController {

    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();
    private Game game;
    private TrialNumber trialNumber;

    public void initGame() {
        List<String> carNames = inputController.getCarNames();
        int trialNumberInput = inputController.getTrialNumber();
        game = new Game(carNames);
        trialNumber = new TrialNumber(trialNumberInput);
    }

    public void playGame() {
        outputView.printResultMessage();
        do {
            RoundResult roundResult = game.race();
            outputView.printRoundResult(roundResult);
            trialNumber.subtractOne();
        } while (!trialNumber.isZero());

        List<CarDto> winners = game.getWinners();
        outputView.printWinners(winners);
    }
}