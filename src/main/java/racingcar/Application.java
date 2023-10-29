package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.RacingView;

public class Application {

    public static void main(String[] args) {
        final RacingView view = new RacingView();
        final RacingController controller = new RacingController(view);
        controller.run();
    }
}
