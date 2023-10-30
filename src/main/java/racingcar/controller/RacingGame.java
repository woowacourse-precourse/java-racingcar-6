package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start(){
        outputView.printRacingCarNameInputMessage();
        String[] carNames = inputView.readRacingCarName();

        outputView.printNumberOfTryInputMessage();
        int numberOfTry = inputView.readNumberOfTry();
    }
}
