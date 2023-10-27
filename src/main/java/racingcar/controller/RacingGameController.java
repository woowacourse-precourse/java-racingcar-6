package racingcar.controller;

import racingcar.dto.request.RacingCarNamesDto;
import racingcar.dto.request.TryCountDto;
import racingcar.model.CarGroup;
import racingcar.model.TryCount;
import racingcar.view.InputView;

public class RacingGameController {
    private final InputView inputView;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        CarGroup carGroup = createCarGroup();
        TryCount tryCount = createTryCount();

    }

    private TryCount createTryCount() {
        TryCountDto tryCountDto = inputView.readTryCount();
        return TryCount.from(tryCountDto.getTryCount());
    }

    private CarGroup createCarGroup() {
        RacingCarNamesDto racingCarNamesDto = inputView.readRacingCarNames();
        return CarGroup.from(racingCarNamesDto.getRacingCarNames());
    }
}
