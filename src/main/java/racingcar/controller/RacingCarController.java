package racingcar.controller;

import static racingcar.common.Constants.CAR_NAME_REQUEST_MESSAGE;

import racingcar.view.OutputView;

public class RacingCarController {
    public void start() {
        OutputView.printInfo(CAR_NAME_REQUEST_MESSAGE);
    }
}
