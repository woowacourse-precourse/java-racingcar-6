package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class RacingController {
    private InputView inputView;

    public RacingController() {
        this.inputView = new InputView();
    }

    public void run() {
        CarList carList = inputView.inputPlayer();
        Integer attempt = inputView.inputAttempt();

        OutputView.printResult();
        for (int i = 0; i < attempt; i++) {
            ArrayList<String> resultList = carList.move();
            OutputView.printStatus(resultList);
        }
    }
}
