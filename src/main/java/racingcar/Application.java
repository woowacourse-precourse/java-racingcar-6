package racingcar;

import racingcar.controller.GameController;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {

        GameController gameController = new GameController(new ConsoleInputView(), new ConsoleOutputView());
        gameController.run();
    }
}
