package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.RacingView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final RacingView view = new RacingView(inputView);
        final RacingController controller = new RacingController(view);
        controller.run();
    }
}
