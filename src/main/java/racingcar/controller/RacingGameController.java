package racingcar.controller;

import racingcar.dto.request.RacingCarNamesDto;
import racingcar.dto.request.TryCountDto;
import racingcar.model.CarGroup;
import racingcar.model.MoveHistory;
import racingcar.model.MovementCondition;
import racingcar.model.RacingGame;
import racingcar.model.TryCount;
import racingcar.view.InputView;

public class RacingGameController {
    private final InputView inputView;
    private final MovementCondition movementCondition;

    public RacingGameController(InputView inputView, MovementCondition movementCondition) {
        this.inputView = inputView;
        this.movementCondition = movementCondition;
    }

    public void run() {
        CarGroup carGroup = createCarGroup();
        TryCount tryCount = createTryCount();
        RacingGame racingGame = RacingGame.initialize(carGroup, tryCount);
        MoveHistory moveHistory = racingGame.playWith(movementCondition);

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
