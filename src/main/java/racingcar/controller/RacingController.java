package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private static final int LOOP_UNTIL_ZERO = 0;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Cars cars = Cars.of(inputView.inputCarName());
        int trialCount = inputView.inputTrialCount();
        outputView.printResultMessage();
        while (trialCount-- > LOOP_UNTIL_ZERO) {
            cars.drawNumber();
            outputView.printExecutionResult(cars);
        }
        outputView.printFinalWinner(cars.getWinnerList());
    }
}
