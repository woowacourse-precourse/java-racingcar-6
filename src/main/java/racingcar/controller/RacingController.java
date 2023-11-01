package racingcar.controller;

import java.util.List;
import racingcar.model.CarState;
import racingcar.model.Racing;
import racingcar.model.intgenerator.RandomIntGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private Racing racing;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void createRacing() {
        List<String> carNames = inputView.askCarNames();
        int tryCount = inputView.askTryCount();
        this.racing = new Racing(carNames, tryCount, new RandomIntGenerator());
    }

    public void playRacing() {
        outputView.printRacingAnnouncement();
        while (racing.canMove()) {
            racing.doMove();
            List<CarState> states = racing.captureCurrentState();
            outputView.printAllCarPositionByState(states);
        }
    }

    public void finishRacing() {
        List<String> winnerCarNames = racing.generateWinnerNames();
        outputView.printWinnerCar(winnerCarNames);
    }
}
