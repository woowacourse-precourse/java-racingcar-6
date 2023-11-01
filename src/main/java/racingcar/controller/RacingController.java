package racingcar.controller;

import racingcar.model.NumberGeneratorImpl;
import racingcar.model.Racing;
import racingcar.view.RacingView;

public class RacingController {

    private final RacingView view;

    public RacingController(RacingView view) {
        this.view = view;
    }

    public void run() {
        final Racing racing = Racing.of(view.inputCarNames(), view.inputTryCount(),
            new NumberGeneratorImpl());
        view.startPrintTryResult();
        while (!racing.isFinished()) {
            racing.race();
            view.showRacingStatus(racing.getRacingStatus());
        }
        view.showRacingWinner(racing);
    }
}
