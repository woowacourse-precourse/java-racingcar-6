package racingcar.controller;

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
        return carNames;
    }

    public int trialCountInput() {
        return inputView.trialCountInput();
    }

    public void notifyExecutionResult() {
        outputView.executionResult();
    }

    public void notifyOneRoundCarResult(String result) {
        outputView.showResult(result);
    }

    public void notifyWinners(String result) {
        outputView.showWinner(result);
    }

}
