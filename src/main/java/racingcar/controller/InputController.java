package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class InputController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void start(){
        outputView.printCarName();
        inputView.getName();

        outputView.printHowManyRound();
        inputView.getNumberOfRound();
    }
}
