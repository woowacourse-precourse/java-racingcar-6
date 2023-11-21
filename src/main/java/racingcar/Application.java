package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public final class Application {
    public static void main(final String[] args) {

        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final RaceController raceController = new RaceController(inputView, outputView);

        raceController.run();
    }
}
