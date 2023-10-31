package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.common.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void raceStart() {
        outputView.printInputCarNames();
        String carNames = inputView.carNames();
        Validator.validateCarNames(carNames);
    }


}
