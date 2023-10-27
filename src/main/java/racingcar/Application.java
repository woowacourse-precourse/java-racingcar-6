package racingcar;

import racingcar.controller.GameController;
import racingcar.view.input.ConsoleInputView;
import racingcar.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController controller = new GameController(
                new ConsoleInputView(),
                new ConsoleOutputView()
        );

        controller.play();
    }
}
