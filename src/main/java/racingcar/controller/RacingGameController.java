package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.view.RacingOutputView;

public class RacingGameController {

    private final RacingInputController racingInputController = new RacingInputController();
    private RacingCars racingCars;
    private int tryCount;

    public void start() {
        set();
        play();
        notice();
    }

    private void set() {
        racingCars = racingInputController.createRacingCars();
        tryCount = racingInputController.createTryCount();
    }

    private void play() {
        RacingOutputView.outputResultMessage();

        for (int i = 0; i < tryCount; i++) {
            RacingOutputView.outputRoundResults(racingCars.playRound());
        }
    }

    private void notice() {
        RacingOutputView.outputWinners(racingCars.noticeWinners());
    }

}
