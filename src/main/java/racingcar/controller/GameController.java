package racingcar.controller;

import racingcar.controller.dto.request.CarNameDto;
import racingcar.controller.dto.request.RaceCountDto;
import racingcar.view.InputView;

public class GameController {
    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        CarNameDto carNameDto = inputView.readCarName();
        RaceCountDto raceCountDto = inputView.readRaceCount();
    }
}
