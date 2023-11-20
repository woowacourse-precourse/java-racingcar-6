package racingcar;

import java.util.List;
import racingcar.domain.car.RoundResult;
import racingcar.domain.car.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private RacingGame racingGame;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initGame();
        race();
        printWinners();
    }

    private void initGame() {
        List<String> carNames = inputView.getCarNames();
        racingGame = new RacingGame(carNames);
    }

    private void race() {
        int trialNumber = inputView.getTrialNumber();
        outputView.printRoundResultMessage();
        raceMultipleRounds(trialNumber);
    }

    private void raceMultipleRounds(int trialNumber) {
        for (int i = 0; i < trialNumber; i++) {
            racingGame.race();
            RoundResult roundResult = racingGame.getRoundResult();
            outputView.printRoundResult(roundResult);
        }
    }

    private void printWinners() {
        Winners winners = racingGame.getWinners();
        outputView.printWinners(winners);
    }
}