package racingcar;

import racingcar.controller.Controller;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = initController();
        controller.run();
    }

    private static Controller initController() {
        return new Controller(initInputView(), initOutputView());
    }

    private static InputView initInputView() {
        return new InputView();
    }

    private static OutputView initOutputView() {
        return new OutputView();
    }
}
