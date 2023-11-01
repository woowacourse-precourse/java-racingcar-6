package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingController racing = new RacingController(new InputView(), new OutputView());
        racing.play();
    }
}
