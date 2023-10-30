package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController(
                new InputView(),
                new ResultView()
        );
        controller.play();
    }
}
