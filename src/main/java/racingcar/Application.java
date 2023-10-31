package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.RacingView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final RacingView view = new RacingView(inputView, outputView);
        final RacingController controller = new RacingController(view);
        controller.run();
    }
}
