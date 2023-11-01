package racingcar.controller;

import racingcar.exception.InputException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class IoController {
    private final InputView inputView;
    private final OutputView outputView;

    public IoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public ArrayList<String> raceCarNameInput() {
        ArrayList<String> carNames = inputView.carNameInput();
        for (String carName : carNames) {
            InputException.checkInputLength(carName);
        }
        return carNames;
    }

    public int trialCountInput() {
        String trialCount =inputView.trialCountInput();
        InputException.checkTrialCountValid(trialCount);
        return Integer.parseInt(trialCount);
    }

    public void notifyExecutionResult() {
        outputView.executionResult();
    }

    public void notifyProgress(String result) {
        outputView.showResult(result);
    }

    public void notifyWinners(String result) {
        outputView.showWinner(result);
    }

}
