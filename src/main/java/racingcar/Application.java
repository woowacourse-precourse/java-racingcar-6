package racingcar;

import controller.RacingGameController;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGameController controller = new RacingGameController(outputView, inputView);
        controller.run();
    }
}
