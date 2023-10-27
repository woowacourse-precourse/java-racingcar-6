package racingcar.controller;

import racingcar.dto.request.RacingCarNamesDto;
import racingcar.dto.request.TryCountDto;
import racingcar.model.CarGroup;
import racingcar.model.MovementCondition;
import racingcar.model.RaceTrackHistory;
import racingcar.model.RacingGame;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MovementCondition movementCondition;

    public RacingGameController(InputView inputView, OutputView outputView, MovementCondition movementCondition) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movementCondition = movementCondition;
    }

    public void run() {
        CarGroup carGroup = createCarGroup();
        TryCount tryCount = createTryCount();
        RacingGame racingGame = RacingGame.initialize(carGroup, tryCount);
        RaceTrackHistory raceTrackHistory = racingGame.playWith(movementCondition);
        printGameResult(raceTrackHistory);
    }

    private void printGameResult(RaceTrackHistory raceTrackHistory) {
        outputView.printGameResult(raceTrackHistory);
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
