package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingController controller = new RacingController(new InputView(), new OutputView());
        controller.createRacing();
        controller.playRacing();
        controller.finishRacing();
    }
}
