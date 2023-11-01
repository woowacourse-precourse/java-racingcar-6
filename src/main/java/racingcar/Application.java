package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.GameControllerImpl;
import racingcar.view.input.ConsoleInputView;
import racingcar.view.input.InputView;
import racingcar.view.output.ConsoleOutputView;
import racingcar.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new ConsoleOutputView();
        InputView inputView = new ConsoleInputView();

        GameController gameController = new GameControllerImpl(outputView, inputView);
        gameController.run();
    }
}
