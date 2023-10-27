package racingcar.controller;

import racingcar.dto.request.RacingCarNamesDto;
import racingcar.view.InputView;

public class RacingGameController {
    private final InputView inputView;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        RacingCarNamesDto racingCarNamesDto = inputView.readRacingCarNames();
    }
}
