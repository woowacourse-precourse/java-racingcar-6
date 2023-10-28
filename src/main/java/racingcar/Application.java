package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController(
                new Race(),
                new InputView(),
                new OutputView()
        );
        controller.start();
    }
}
