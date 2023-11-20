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
        List<String> carNames = inputView.getCarNames();
        int trialNumber = inputView.getTrialNumber();
        racingGame = new RacingGame(carNames);

        outputView.printRoundResultMessage();
        for (int i = 0; i < trialNumber; i++) {
            racingGame.race();
            RoundResult roundResult = racingGame.getRoundResult();
            outputView.printRoundResult(roundResult);
        }

        Winners winners = racingGame.getWinners();
        outputView.printWinners(winners);
    }
}