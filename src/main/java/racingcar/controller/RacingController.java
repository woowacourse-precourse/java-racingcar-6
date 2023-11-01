package racingcar.controller;

import racingcar.dto.request.CarNames;
import racingcar.dto.request.TryCount;
import racingcar.model.NumberGenerator;
import racingcar.model.Racing;
import racingcar.view.RacingView;

public class RacingController {

    private final RacingView view;

    public RacingController(RacingView view) {
        this.view = view;
    }

    public void run() {
        final CarNames carNames = view.inputCarNames();
        final TryCount tryCount = view.inputTryCount();
        final Racing racing = Racing.of(carNames, tryCount, new NumberGenerator());
        view.startPrintTryResult();
        while (!racing.isFinished()) {
            racing.race();
            view.showRacingStatus(racing.getRacingStatus());
        }
        view.showRacingWinner(racing.getWinnerNames());
    }
}
