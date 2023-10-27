package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {


    public void runGame() {
        startGame();
    }


    private void startGame() {
        OutputView.printStartMessage();
        String [] players = InputView.getPlayerInput();
        OutputView.printTryNumberMessage();
        int tryNumber = InputView.getTryNumberInput();
    }
}
