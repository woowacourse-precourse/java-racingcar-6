package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class RacingController {
    private final InputView inputView;

    public RacingController() {
        inputView = new InputView();
    }

    public void start() {
        inputView.printRequestCarName();
        inputView.printRequestAttemptsNumber();

    }
}
