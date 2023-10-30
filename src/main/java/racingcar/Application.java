package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingCarController racingGameController = new RacingCarController(inputView(), outputView());
        racingGameController.run();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
