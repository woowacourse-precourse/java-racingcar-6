package racingcar.controller;

import racingcar.dto.request.RacingCarNamesDto;
import racingcar.model.CarGroup;
import racingcar.view.InputView;

public class RacingGameController {
    private final InputView inputView;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        createCarGroup();

    }

    private CarGroup createCarGroup() {
        RacingCarNamesDto racingCarNamesDto = inputView.readRacingCarNames();
        return CarGroup.from(racingCarNamesDto.getRacingCarNames());
    }
}
