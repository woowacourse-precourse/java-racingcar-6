package racingcarv2.controller;

import racingcarv2.view.InputView;
import racingcarv2.view.OutputView;

public class RacingCarController {
    public void run() {
        registerCarsByNames();
        registerRoundTotal();
        displayRacingStatus();
        displayWinner();
    }

    private void registerCarsByNames() {
        OutputView.printInputCarNames();
        InputView.inputCarNames();
    }

    private void registerRoundTotal() {
    }

    private void displayRacingStatus() {
    }

    private void displayWinner() {
    }




}
