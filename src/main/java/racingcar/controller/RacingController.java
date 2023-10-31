package racingcar.controller;

import racingcar.dto.CarNames;
import racingcar.dto.TryCount;
import racingcar.model.Racing;
import racingcar.view.RacingView;

public class RacingController {

    private final RacingView view;

    public RacingController(RacingView view) {
        this.view = view;
    }

    public void run() {
        final CarNames carNames = view.inputCarNames();
        TryCount tryCount = view.inputTryCount();
        final Racing racing = Racing.of(carNames, tryCount);
        view.startPrintTryResult();
        for (Integer i = 0; i < tryCount.getCount(); i++) {
            racing.tryCarsMoveForward();
            view.showRacingStatus(racing.getRacingStatus());
        }
        view.showRacingWinner(racing);
    }
}
