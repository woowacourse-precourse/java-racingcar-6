package racingcar.controller;

import java.util.ArrayList;
import racingcar.view.OutputView;
import racingcar.view.InputView;

public class RacingController {

    public void start() {
        OutputView.printInputCarName();
        ArrayList<String> carNames = InputView.inputCarName();
        OutputView.printInputRacingCount();
        Integer carRacingCount = InputView.inputRacingCount();
    }
}